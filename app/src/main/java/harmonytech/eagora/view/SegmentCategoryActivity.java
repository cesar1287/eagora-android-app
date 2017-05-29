package harmonytech.eagora.view;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.FirebaseHelper;
import harmonytech.eagora.controller.util.Singleton;
import harmonytech.eagora.controller.util.Utility;

public class SegmentCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    HashMap<String, ArrayList<String>> subcategorias;
    String segmento;
    ArrayList<String> arraySegmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_category);

        segmento = getIntent().getStringExtra(Utility.SEGMENTO);

        subcategorias = Singleton.getInstance().getSegmentos();

        arraySegmento = subcategorias.get(segmento);

        setupUI();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(this, SegmentDetailsActivity.class);
        intent.putExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_CATEGORY, segmento);
        intent.putExtra(FirebaseHelper.FIREBASE_DATABASE_PROVIDER_SUBCATEGORY, arraySegmento.get(i));
        startActivity(intent);
    }

    private void setupUI() {

        ActionBar actoActionBar = getSupportActionBar();

        if(actoActionBar!=null){
            actoActionBar.setTitle(segmento);
            actoActionBar.setDefaultDisplayHomeAsUpEnabled(true);
            actoActionBar.setDisplayHomeAsUpEnabled(true);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraySegmento);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }
}
