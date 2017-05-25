package harmonytech.eagora.view;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import harmonytech.eagora.R;
import harmonytech.eagora.controller.domain.Segment;
import harmonytech.eagora.controller.fragment.SegmentFragment;
import harmonytech.eagora.controller.util.Utility;

public class MainActivity extends AppCompatActivity {

    ArrayList<Segment> recipesList = new ArrayList<>();
    SegmentFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI() {

        Segment animal = new Segment();
        animal.setName(Utility.SEGMENTO_ANIMAIS);
        Uri uriAnimal = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_animal);
        animal.setBanner(uriAnimal);
        recipesList.add(animal);

        Segment arteCultura = new Segment();
        arteCultura.setName(Utility.SEGMENTO_ARTE_CULTURA);
        Uri uriArteCultura = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_arte_cultura);
        arteCultura.setBanner(uriArteCultura);
        recipesList.add(arteCultura);

        Segment assistenciaTecnica = new Segment();
        assistenciaTecnica.setName(Utility.SEGMENTO_ASSISTENCIA_TECNICA);
        Uri uriAssistenciaTecnica = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_assistencia_tecnica);
        assistenciaTecnica.setBanner(uriAssistenciaTecnica);
        recipesList.add(assistenciaTecnica);

        Segment aulas = new Segment();
        aulas.setName(Utility.SEGMENTO_AULAS);
        Uri uriAulas = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_aulas);
        aulas.setBanner(uriAulas);
        recipesList.add(aulas);

        Segment autos = new Segment();
        autos.setName(Utility.SEGMENTO_AUTOS);
        Uri uriAutos = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_autos);
        autos.setBanner(uriAutos);
        recipesList.add(aulas);

        Segment belezaEstetica = new Segment();
        belezaEstetica.setName(Utility.SEGMENTO_BELEZA_ESTETICA);
        Uri uriBelezaEstetica = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_beleza);
        belezaEstetica.setBanner(uriBelezaEstetica);
        recipesList.add(belezaEstetica);

        Segment construcao = new Segment();
        construcao.setName(Utility.SEGMENTO_CONSTRUCAO);
        Uri uriConstrucao = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_construcao);
        construcao.setBanner(uriConstrucao);
        recipesList.add(construcao);

        Segment consultoria = new Segment();
        consultoria.setName(Utility.SEGMENTO_CONSULTORIA);
        Uri uriConsultoria = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_consultoria);
        consultoria.setBanner(uriConsultoria);
        recipesList.add(consultoria);

        Segment design = new Segment();
        design.setName(Utility.SEGMENTO_DESIGN);
        Uri uriDesign = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_design);
        design.setBanner(uriDesign);
        recipesList.add(design);

        Segment eventos = new Segment();
        eventos.setName(Utility.SEGMENTO_EVENTOS);
        Uri uriEventos = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_eventos);
        eventos.setBanner(uriEventos);
        recipesList.add(eventos);

        Segment saude = new Segment();
        saude.setName(Utility.SEGMENTO_SAUDE);
        Uri uriSaude = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_saude);
        saude.setBanner(uriSaude);
        recipesList.add(saude);

        Segment servicosDomesticos = new Segment();
        servicosDomesticos.setName(Utility.SEGMENTO_SERVICOS_DOMESTICOS);
        Uri uriServicoDomestico = Uri.parse(Utility.URI_PACKAGE + R.drawable.eagora_icon_servicos_domesticos);
        servicosDomesticos.setBanner(uriServicoDomestico);
        recipesList.add(servicosDomesticos);

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
