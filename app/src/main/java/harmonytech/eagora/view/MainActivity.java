package harmonytech.eagora.view;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.Segment;
import harmonytech.eagora.controller.fragment.SegmentFragment;

public class MainActivity extends AppCompatActivity {

    ArrayList<Segment> recipesList = new ArrayList<>();
    SegmentFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Segment s1 = new Segment();
        s1.setName("Serviços");
        s1.setBanner("http://www.eleveninstrumentacao.com.br/ESW/Images/servicos.jpg");
        recipesList.add(s1);

        Segment s2 = new Segment();
        s2.setName("Metalúrgica");
        s2.setBanner("http://i.imgur.com/7unwhF0.jpg");
        recipesList.add(s2);

        Segment s3 = new Segment();
        s3.setName("Metalúrgica");
        s3.setBanner("http://i.imgur.com/7unwhF0.jpg");
        recipesList.add(s3);

        frag = (SegmentFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null) {
            frag = new SegmentFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.segments_fragment_container, frag, "mainFrag");
            ft.commit();
        }
    }

    public List<Segment> getRecipesList() {
        return recipesList;
    }
}
