package harmonytech.eagora.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;

import java.util.ArrayList;
import java.util.HashMap;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.FirebaseHelper;
import harmonytech.eagora.controller.util.Singleton;
import harmonytech.eagora.controller.util.Utility;

public class SegmentCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    HashMap<String, HashMap<String, ArrayList<String>>> subcategorias;
    String segmento, segmentoFirebase;
    HashMap<String, ArrayList<String>> arraySegmento;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_category);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        segmento = getIntent().getStringExtra(Utility.SEGMENTO);

        segmentoFirebase = getIntent().getStringExtra(Utility.SEGMENTO_FIREBASE);

        subcategorias = Singleton.getInstance().getSegmentos();

        arraySegmento = subcategorias.get(segmento);

        setupUI();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if(Utility.isConnected(this)){
            Intent intent = new Intent(this, SegmentDetailsActivity.class);
            intent.putExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_CATEGORY, segmentoFirebase);
            intent.putExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_SUBCATEGORY, arraySegmento.get(Utility.HASH_MAP_FIREBASE).get(i));
            intent.putExtra(Utility.SEGMENT_DETAILS_TITLE, arraySegmento.get(Utility.HASH_MAP_TELA).get(i));
            startActivity(intent);
        }else{
            Utility.showSnackBarErrorMessage(this, getResources().getString(R.string.no_internet_connection));
        }
    }

    private void setupUI() {

        ActionBar actoActionBar = getSupportActionBar();

        if(actoActionBar!=null){
            actoActionBar.setTitle(segmento);
            actoActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actoActionBar.setDisplayHomeAsUpEnabled(true);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraySegmento.get(Utility.HASH_MAP_TELA));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }
}
