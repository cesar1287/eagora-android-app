package harmonytech.eagora.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.ProviderFirebase;
import harmonytech.eagora.controller.util.Utility;

public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnCadastrar;
    TextInputLayout etNome, etEmail, etCEP, etNascimento, etCPF, etTelefone;
    Spinner spCategoria, spEspecialidade;

    DatabaseReference mDatabase;

    TextWatcher cpfMask, phoneMask, birthMask, postalCodeMask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);

        etNome = (TextInputLayout) findViewById(R.id.etNome);
        etEmail = (TextInputLayout) findViewById(R.id.etEmail);
        etNascimento = (TextInputLayout) findViewById(R.id.etNascimento);
        etCEP = (TextInputLayout) findViewById(R.id.etCep);
        etCPF = (TextInputLayout) findViewById(R.id.etCpf);
        etTelefone = (TextInputLayout) findViewById(R.id.etTelefone);
        spCategoria = (Spinner) findViewById(R.id.spCategorias);
        spEspecialidade = (Spinner) findViewById(R.id.spSubCategoria);

        setupFieldMasks();

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
                attemptLogin();
            break;
        }
    }

    public void attemptLogin(){
        String name, email, birth, postalCode, cpf, phone;

        boolean allFieldsFilled = true;
        boolean allFilledRight = true;
        boolean allFilledCorrectly = true;

        name = etNome.getEditText().getText().toString();
        email = etEmail.getEditText().getText().toString();
        birth = etNascimento.getEditText().getText().toString();
        postalCode = etCEP.getEditText().getText().toString();
        cpf = etCPF.getEditText().getText().toString();
        phone = etTelefone.getEditText().getText().toString();

        if(name.equals("")){
            allFieldsFilled = false;
            etNome.setError("Campo obrigatório");
        }else{
            etNome.setErrorEnabled(false);
        }

        if(cpf.equals("")){
            allFieldsFilled = false;
            allFilledRight = false;
            etCPF.setError("Campo obrigatório");
        }else{
            etCPF.setErrorEnabled(false);
        }

        if(phone.equals("")){
            allFieldsFilled = false;
            etTelefone.setError("Campo obrigatório");
        }else{
            etTelefone.setErrorEnabled(false);
        }

        if(email.equals("")){
            allFieldsFilled = false;
            etEmail.setError("Campo obrigatório");
        }else{
            etEmail.setErrorEnabled(false);
        }

        if(birth.equals("")){
            allFieldsFilled = false;
            etNascimento.setError("Campo obrigatório");
        }else{
            etNascimento.setErrorEnabled(false);
        }

        if(postalCode.equals("")){
            allFieldsFilled = false;
            etCEP.setError("Campo obrigatório");
        }else{
            etCEP.setErrorEnabled(false);
        }

        if(allFieldsFilled) {
            if (cpf.length() < 14) {
                allFilledRight = false;
                etCPF.setError("O CPF têm 11 dígitos");
            } else {
                etCPF.setErrorEnabled(false);
            }

            if (phone.length() < 14) {
                allFilledRight = false;
                etTelefone.setError("Telefone inválido");
            } else {
                etTelefone.setErrorEnabled(false);
            }

            if (birth.length() < 10) {
                allFilledRight = false;
                etNascimento.setError("Data de nascimento inválida");
            } else {
                etNascimento.setErrorEnabled(false);
            }

            if (postalCode.length() < 9) {
                allFilledRight = false;
                etCEP.setError("CEP inválido");
            } else {
                etCEP.setErrorEnabled(false);
            }
        }

        if(allFilledRight){
            cpf = cpf.replaceAll("[.]", "").replaceAll("[-]","");

            if(!Utility.isValidCPF(cpf)){
                allFilledCorrectly = false;
                etCPF.setError("CPF inválido");
            }else{
                etCPF.setErrorEnabled(false);
            }
        }

        if(allFieldsFilled && allFilledRight && allFilledCorrectly) {
            writeNewProvider(name, email, birth, postalCode, cpf);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void writeNewProvider(String name, String email, String birth, String postalCode, String cpf) {
        ProviderFirebase providerFirebase = new ProviderFirebase(name, email, birth, postalCode, cpf);

        mDatabase.child("assistenciaTecnica").child("computador").child("random"+
                String.valueOf(new Random().nextInt(100))).setValue(providerFirebase);
    }

    public void setupFieldMasks(){
        cpfMask = Utility.insertMask("###.###.###-##", etCPF.getEditText());
        etCPF.getEditText().addTextChangedListener(cpfMask);

        phoneMask = Utility.insertMask("(##)#####-####", etTelefone.getEditText());
        etTelefone.getEditText().addTextChangedListener(phoneMask);

        birthMask = Utility.insertMask("##/##/####", etNascimento.getEditText());
        etNascimento.getEditText().addTextChangedListener(birthMask);

        postalCodeMask = Utility.insertMask("#####-###", etCEP.getEditText());
        etCEP.getEditText().addTextChangedListener(postalCodeMask);
    }
}
