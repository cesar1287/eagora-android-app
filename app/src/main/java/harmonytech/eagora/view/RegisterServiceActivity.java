package harmonytech.eagora.view;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.ProviderFirebase;
import harmonytech.eagora.controller.util.Singleton;
import harmonytech.eagora.controller.util.Utility;

public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Button btnCadastrar;
    TextInputLayout etNome, etEmail, etCEP, etNascimento, etCPF, etTelefone;
    Spinner spCategoria, spEspecialidade;

    DatabaseReference mDatabase;

    TextWatcher cpfMask, phoneMask, birthMask, postalCodeMask;

    ArrayAdapter<String> adapterSubCategorias;

    HashMap<String, HashMap<String, ArrayList<String>>> subareas;
    HashMap<String, String> segmentosFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);

        ArrayList<String> areas = Singleton.getInstance().getAreas();
        subareas = Singleton.getInstance().getSegmentos();
        segmentosFirebase = Singleton.getInstance().getSegmentosFirebase();

        etNome = (TextInputLayout) findViewById(R.id.etNome);
        etEmail = (TextInputLayout) findViewById(R.id.etEmail);
        etNascimento = (TextInputLayout) findViewById(R.id.etNascimento);
        etCEP = (TextInputLayout) findViewById(R.id.etCep);
        etCPF = (TextInputLayout) findViewById(R.id.etCpf);
        etTelefone = (TextInputLayout) findViewById(R.id.etTelefone);

        spCategoria = (Spinner) findViewById(R.id.spCategorias);
        ArrayAdapter<String> adapterCategorias = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, areas);
        spCategoria.setAdapter(adapterCategorias); // this will set list of values to spinner
        spCategoria.setOnItemSelectedListener(this);

        spEspecialidade = (Spinner) findViewById(R.id.spSubCategoria);

        setupFieldMasks();

        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnCadastrar.setOnClickListener(this);

        mDatabase = FirebaseDatabase.getInstance().getReference();
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
            writeNewProvider(name, email, birth, postalCode, cpf, phone);
            Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void writeNewProvider(String name, String email, String birth, String postalCode, String cpf, String phone) {
        ProviderFirebase providerFirebase = new ProviderFirebase(name, email, birth, postalCode, cpf, phone);

        mDatabase
                .child(segmentosFirebase.get(spCategoria.getSelectedItem().toString()))
                .child(subareas.get(spCategoria.getSelectedItem().toString()).get(Utility.HASH_MAP_FIREBASE).get(spEspecialidade.getSelectedItemPosition()))
                .child(cpf).setValue(providerFirebase);
    }

    public void setupFieldMasks(){
        cpfMask = Utility.insertMask(getResources().getString(R.string.cpf_mask), etCPF.getEditText());
        etCPF.getEditText().addTextChangedListener(cpfMask);

        phoneMask = Utility.insertMask(getResources().getString(R.string.phone_mask), etTelefone.getEditText());
        etTelefone.getEditText().addTextChangedListener(phoneMask);

        birthMask = Utility.insertMask(getResources().getString(R.string.birth_mask), etNascimento.getEditText());
        etNascimento.getEditText().addTextChangedListener(birthMask);

        postalCodeMask = Utility.insertMask(getResources().getString(R.string.postalCode_mask), etCEP.getEditText());
        etCEP.getEditText().addTextChangedListener(postalCodeMask);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int id = adapterView.getId();

        switch (id){
            case R.id.spCategorias:

                if(adapterSubCategorias==null) {
                    adapterSubCategorias = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, subareas.get(spCategoria.getSelectedItem().toString()).get(Utility.HASH_MAP_TELA));
                    spEspecialidade.setAdapter(adapterSubCategorias); // this will set list of values to spinner
                }else{
                    adapterSubCategorias.clear();
                    adapterSubCategorias.addAll(subareas.get(spCategoria.getSelectedItem().toString()).get(Utility.HASH_MAP_TELA));
                    adapterSubCategorias.notifyDataSetChanged();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
