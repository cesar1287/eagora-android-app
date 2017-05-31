package harmonytech.eagora.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.ProviderFirebase;

public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCadastrar;
    EditText etNome;
    EditText etEmail;
    EditText etCep;
    EditText etNascimento;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);

        etNome = (EditText) findViewById(R.id.etNome);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etNascimento = (EditText) findViewById(R.id.etNascimento);
        etCep = (EditText) findViewById(R.id.etCep);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.btnCadastrar:
                writeNewProvider(etNome.getText().toString(), etEmail.getText().toString(),
                        etNascimento.getText().toString(), Long.parseLong(etCep.getText().toString()));
                Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            break;
        }
    }

    private void writeNewProvider(String name, String email, String birth, long postalCode) {
        ProviderFirebase providerFirebase = new ProviderFirebase(name, email, birth, postalCode);

        mDatabase.child("assistenciaTecnica").child("computador").child("random"+
                String.valueOf(new Random().nextInt(100))).setValue(providerFirebase);
    }
}
