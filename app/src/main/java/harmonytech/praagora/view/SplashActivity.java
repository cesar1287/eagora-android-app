package harmonytech.praagora.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import harmonytech.praagora.R;
import harmonytech.praagora.controller.util.Singleton;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setupLists();

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null) {
            actionBar.hide();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, SingWithActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }

    private void setupLists() {

        Singleton.getInstance().getSegmentos();
        Singleton.getInstance().getAreas();
        Singleton.getInstance().getSegmentosFirebase();
    }

}
