package harmonytech.eagora.view;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.Provider;
import harmonytech.eagora.controller.util.FirebaseHelper;

public class SegmentDetailsActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ProgressDialog dialog;
    Query segmentoFirebase;

    ValueEventListener valueEventListener;
    ValueEventListener singleValueEventListener;

    String category, subcategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_details);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        category = getIntent().getStringExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_CATEGORY);
        subcategory = getIntent().getStringExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_SUBCATEGORY);

        setupUI();

        dialog = ProgressDialog.show(this,"", this.getResources().getString(R.string.loading_segments_pls_wait), true, false);

        loadList();
    }

    private void setupUI() {

        ActionBar actionBar = getSupportActionBar();

        if(actionBar!=null){
            actionBar.setTitle(subcategory);
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);

            segmentoFirebase = mDatabase.child(category);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        segmentoFirebase.removeEventListener(valueEventListener);
        segmentoFirebase.removeEventListener(singleValueEventListener);
    }

    private void loadList() {

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Provider p;
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    p = new Provider();
                    p.setName((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_NAME).getValue());
                    p.setEmail((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_EMAIL).getValue());
                    p.setPhone((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_PHONE).getValue());
                    p.setPostalCode((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_POSTAL_CODE).getValue());
                    p.setBirth((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_BIRTH).getValue());
                    p.setSubcategory((String)postSnapshot.child(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_SUBCATEGORY).getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SegmentDetailsActivity.this, R.string.error_loading_segments, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        singleValueEventListener = new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {



                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(SegmentDetailsActivity.this, R.string.error_loading_segments, Toast.LENGTH_LONG).show();
                finish();
            }
        };

        segmentoFirebase.addValueEventListener(valueEventListener);

        segmentoFirebase.addListenerForSingleValueEvent(singleValueEventListener);
    }
}
