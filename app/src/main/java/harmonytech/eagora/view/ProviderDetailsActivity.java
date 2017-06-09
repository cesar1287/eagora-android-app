package harmonytech.eagora.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.Utility;

public class ProviderDetailsActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvPhone, tvCategory, tvSubcategory, tvWpp;
    RatingBar rbRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_details);

        tvCategory = (TextView) findViewById(R.id.detailsCategory);
        tvCategory.setText(getIntent().getStringExtra(Utility.PROVIDER_CATEGORY));

        tvSubcategory = (TextView) findViewById(R.id.detailsSpecialty);
        tvSubcategory.setText(getIntent().getStringExtra(Utility.PROVIDER_SUBCATEGORY));

        tvName = (TextView) findViewById(R.id.detailsName);
        tvName.setText(getIntent().getStringExtra(Utility.PROVIDER_NAME));

        tvEmail = (TextView) findViewById(R.id.detailsEmail);
        tvEmail.setText(getIntent().getStringExtra(Utility.PROVIDER_EMAIL));

        tvPhone = (TextView) findViewById(R.id.detailsPhone);
        tvPhone.setText(getIntent().getStringExtra(Utility.PROVIDER_PHONE));

        tvWpp = (TextView) findViewById(R.id.detailsWpp);
        tvWpp.setText(getIntent().getStringExtra(Utility.PROVIDER_PHONE));

        rbRate = (RatingBar) findViewById(R.id.ratingBar);
        rbRate.setRating((float) getIntent().getDoubleExtra(Utility.PROVIDER_RATE, 0.01));

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(0);
        }
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


    public void callProvider(View view) {
        String phone;
        phone = tvPhone.getText().toString();
        Utility.callPhone(this, phone);
    }

    public void chamarWpp(View view) {
        String wpp;
        wpp = removeCharactersPhone();
        Toast.makeText(this, wpp, Toast.LENGTH_LONG).show();
        Utility.openWhatsApp(this, wpp);
    }

    public String removeCharactersPhone(){
        String phone;
        String newPhone;
        phone = tvPhone.getText().toString();
        newPhone = phone.replaceAll("\\(","").replaceAll("\\)","").replace("-","");
        newPhone = "55"+newPhone;
        StringBuilder sb = new StringBuilder(newPhone);
        sb.deleteCharAt(4);
        newPhone = sb.toString();

        return newPhone;
    }
}
