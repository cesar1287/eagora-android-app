package harmonytech.eagora.view;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.Utility;

public class ContactUsActivity extends AppCompatActivity {

    TextInputLayout nome, telefone, email, cidade, mensagem;

    TextWatcher phoneMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null) {
            actionBar.setTitle(Utility.changeActionBarTitle(this, actionBar.getTitle().toString()));
        }

        nome = (TextInputLayout)findViewById(R.id.contactName);
        telefone = (TextInputLayout)findViewById(R.id.contactPhone);
        email = (TextInputLayout)findViewById(R.id.contactEmail);
        cidade = (TextInputLayout)findViewById(R.id.contactCity);
        mensagem = (TextInputLayout)findViewById(R.id.contactMessage);

        setupFieldMasks();

    }

    public void enviarEmail(View view){


        String nomeRemetente = nome.getEditText().getText().toString();
        String telefoneRemetente = telefone.getEditText().getText().toString();
        String emailRemetente = email.getEditText().getText().toString();
        String cidadeRementente = cidade.getEditText().getText().toString();
        String mensagemRemetente = mensagem.getEditText().getText().toString();

        StringBuilder sb = new StringBuilder();
        sb.append("Nome: " + nomeRemetente).append("\n");
        sb.append("Telefone: " + telefoneRemetente).append("\n");
        sb.append("Email: "+ emailRemetente).append("\n");
        sb.append("Cidade: " + cidadeRementente).append("\n");
        sb.append("\n\n\n");
        sb.append("Mensagem: "+ mensagemRemetente).append("\n");

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {"islane.junior@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Fale Conosco - Eagora");
        email.putExtra(Intent.EXTRA_TEXT, sb.toString());
        email.setType("plain/text");
        startActivity(Intent.createChooser(email, "Enviando Email..."));

    }

    public void setupFieldMasks(){
        phoneMask = Utility.insertMask(getResources().getString(R.string.phone_mask), telefone.getEditText());
        telefone.getEditText().addTextChangedListener(phoneMask);
    }

}
