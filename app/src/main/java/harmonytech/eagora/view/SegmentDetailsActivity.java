package harmonytech.eagora.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.util.Singleton;
import harmonytech.eagora.controller.util.Utility;

public class SegmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_details);

       /* String teste = getIntent().getStringExtra(Utility.SEGMENTO);

        HashMap<String, ArrayList<String>> subcategorias = Singleton.getInstance().getSegmentos();

        ArrayList<String> teste1 = subcategorias.get(teste);

        Toast.makeText(this, teste1.get(0), Toast.LENGTH_SHORT).show();*/
    }
}
