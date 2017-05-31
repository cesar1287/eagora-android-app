package harmonytech.eagora.controller.domain;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class ProviderFirebase {

    public String name, email, birth;
    public long phone, postalCode, rate;

    public ProviderFirebase() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ProviderFirebase(String name, String email, String birth, long postalCode) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.postalCode = postalCode;
    }
}
