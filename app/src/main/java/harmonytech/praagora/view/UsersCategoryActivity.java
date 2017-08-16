package harmonytech.praagora.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import harmonytech.praagora.R;

public class UsersCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_category);
    }

    public void buttonProvider(View view) {
        Intent i = new Intent(UsersCategoryActivity.this, SingWithActivity.class);
        startActivity(i);
    }

    public void button_client(View view) {
        Intent i = new Intent(UsersCategoryActivity.this, SingWithActivity.class);
        startActivity(i);

    }
}
