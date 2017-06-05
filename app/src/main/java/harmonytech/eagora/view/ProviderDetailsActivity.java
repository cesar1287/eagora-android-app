package harmonytech.eagora.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import harmonytech.eagora.R;

public class ProviderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_details);

        getSupportActionBar().setElevation(0);
    }
}
