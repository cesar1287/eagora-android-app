package harmonytech.praagora.controller.domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ProviderFirebase {

    public String name, email, birth, cpf, postalCode, phone;
    public double rate;

    public ProviderFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ProviderFirebase(String name, String email, String birth, String postalCode, String cpf, String phone, double rate) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.postalCode = postalCode;
        this.cpf = cpf;
        this.phone = phone;
        this.rate = rate;
    }
}
