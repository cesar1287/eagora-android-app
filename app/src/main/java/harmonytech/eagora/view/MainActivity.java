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
        animal.setName("Animais");
        Uri uriAnimal = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_animal);
        animal.setBanner(uriAnimal);
        recipesList.add(animal);

        Segment arteCultura = new Segment();
        arteCultura.setName("Arte e Cultura");
        Uri uriArteCultura = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_arte_cultura);
        arteCultura.setBanner(uriArteCultura);
        recipesList.add(arteCultura);

        Segment assistenciaTecnica = new Segment();
        assistenciaTecnica.setName("Assistência Técnica");
        Uri uriAssistenciaTecnica = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_assistencia_tecnica);
        assistenciaTecnica.setBanner(uriAssistenciaTecnica);
        recipesList.add(assistenciaTecnica);

        Segment aulas = new Segment();
        aulas.setName("Aulas");
        Uri uriAulas = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_aulas);
        aulas.setBanner(uriAulas);
        recipesList.add(aulas);

        Segment autos = new Segment();
        autos.setName("Autos");
        Uri uriAutos = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_autos);
        autos.setBanner(uriAutos);
        recipesList.add(aulas);

        Segment belezaEstetica = new Segment();
        belezaEstetica.setName("Beleza e Estética");
        Uri uriBelezaEstetica = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_beleza);
        belezaEstetica.setBanner(uriBelezaEstetica);
        recipesList.add(belezaEstetica);

        Segment construcao = new Segment();
        construcao.setName("Construção e Reformas");
        Uri uriConstrucao = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_construcao);
        construcao.setBanner(uriConstrucao);
        recipesList.add(construcao);

        Segment consultoria = new Segment();
        consultoria.setName("Consultoria");
        Uri uriConsultoria = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_consultoria);
        consultoria.setBanner(uriConsultoria);
        recipesList.add(consultoria);

        Segment design = new Segment();
        design.setName("Design e Tecnologia");
        Uri uriDesign = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_design);
        design.setBanner(uriDesign);
        recipesList.add(design);

        Segment eventos = new Segment();
        eventos.setName("Eventos");
        Uri uriEventos = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_eventos);
        eventos.setBanner(uriEventos);
        recipesList.add(eventos);

        Segment saude = new Segment();
        saude.setName("Saúde");
        Uri uriSaude = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_saude);
        saude.setBanner(uriSaude);
        recipesList.add(saude);

        Segment servicosDomesticos = new Segment();
        servicosDomesticos.setName("Serviços Domésticos");
        Uri uriServicoDomestico = Uri.parse("android.resource://harmonytech.eagora/" + R.drawable.eagora_icon_servicos_domesticos);
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
