package harmonytech.eagora.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.Utility;

public class DoubtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubt);

        ActionBar actoActionBar = getSupportActionBar();

        actoActionBar.setTitle("Dúvidas Frequentes");
        actoActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actoActionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
