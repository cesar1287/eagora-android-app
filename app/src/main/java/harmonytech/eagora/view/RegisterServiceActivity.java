package harmonytech.eagora.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.ProviderFirebase;

public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCadastrar;
    EditText etNome, etEmail, etCEP, etNascimento, etCPF;
    Spinner spCategoria, spEspecialidade;

    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);

        etNome = (EditText) findViewById(R.id.etNome);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etNascimento = (EditText) findViewById(R.id.etNascimento);
        etCEP = (EditText) findViewById(R.id.etCep);
        etCPF = (EditText) findViewById(R.id.etCpf);
        spCategoria = (Spinner) findViewById(R.id.spCategorias);
        spEspecialidade = (Spinner) findViewById(R.id.spSubCategoria);

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        ActionBar actoActionBar = getSupportActionBar();
        if(actoActionBar!=null) {
            actoActionBar.setTitle("Cadastro de serviços");
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.btnCadastrar:

                String name, email, birth, postalCode, cpf, phone;

                name = etNome.getText().toString();
                email = etEmail.getText().toString();
                birth = etNascimento.getText().toString();
                postalCode = etCEP.getText().toString();
                cpf = etCPF.getText().toString();

                writeNewProvider(name, email, birth, postalCode, cpf);
                Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            break;
        }
    }

    private void writeNewProvider(String name, String email, String birth, String postalCode, String cpf) {
        ProviderFirebase providerFirebase = new ProviderFirebase(name, email, birth, postalCode, cpf);

        mDatabase.child("assistenciaTecnica").child("computador").child("random"+
                String.valueOf(new Random().nextInt(100))).setValue(providerFirebase);
    }

}
