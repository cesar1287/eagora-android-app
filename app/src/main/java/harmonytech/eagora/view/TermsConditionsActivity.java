package harmonytech.eagora.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.Utility;

public class TermsConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_conditions);

        ActionBar actoActionBar = getSupportActionBar();

        actoActionBar.setTitle(Utility.changeActionBarTitle(this, actoActionBar.getTitle().toString()));
    }
}
