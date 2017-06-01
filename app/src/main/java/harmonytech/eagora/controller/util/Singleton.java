package harmonytech.eagora.controller.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Singleton {

    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return uniqueInstance;
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> getSegmentos(){

        HashMap<String, HashMap<String, ArrayList<String>>> subcategoriasSegmentos = new HashMap<>();

        HashMap<String, ArrayList<String>> assistenciaTelas = new HashMap<>();

        ArrayList<String> assistenciaTecnica = new ArrayList<>();
        assistenciaTecnica.add("Ar condicionado");
        assistenciaTecnica.add("Câmera");
        assistenciaTecnica.add("Computador");
        assistenciaTecnica.add("Eletrodomésticos");
        assistenciaTecnica.add("Eletrônicos");
        assistenciaTecnica.add("Outros");
        assistenciaTecnica.add("Tablets");
        assistenciaTecnica.add("Telefonia");

        ArrayList<String> assistenciaTecnicaFirebase = new ArrayList<>();
        assistenciaTecnicaFirebase.add("ar_condicionado");
        assistenciaTecnicaFirebase.add("camera");
        assistenciaTecnicaFirebase.add("computador");
        assistenciaTecnicaFirebase.add("eletrodomesticos");
        assistenciaTecnicaFirebase.add("eletronicos");
        assistenciaTecnicaFirebase.add("outros");
        assistenciaTecnicaFirebase.add("tablets");
        assistenciaTecnicaFirebase.add("telefonia");

        assistenciaTelas.put(Utility.HASH_MAP_TELA, assistenciaTecnica);
        assistenciaTelas.put(Utility.HASH_MAP_FIREBASE, assistenciaTecnicaFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_ASSISTENCIA_TECNICA, assistenciaTelas);

        HashMap<String, ArrayList<String>> animaisTelas = new HashMap<>();

        ArrayList<String> animais = new ArrayList<>();
        animais.add("Ar condicionado");
        animais.add("Câmera");
        animais.add("Computador");
        animais.add("Eletrodomésticos");
        animais.add("Eletrônicos");
        animais.add("Outros");
        animais.add("Tablets");
        animais.add("Telefonia");

        ArrayList<String> animaisFirebase = new ArrayList<>();
        animaisFirebase.add("ar_condicionado");
        animaisFirebase.add("camera");
        animaisFirebase.add("computador");
        animaisFirebase.add("eletrodomesticos");
        animaisFirebase.add("eletronicos");
        animaisFirebase.add("outros");
        animaisFirebase.add("tablets");
        animaisFirebase.add("telefonia");

        animaisTelas.put(Utility.HASH_MAP_TELA, animais);
        animaisTelas.put(Utility.HASH_MAP_FIREBASE, animaisFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_ANIMAIS, animaisTelas);

        HashMap<String, ArrayList<String>> arteCulturaTelas = new HashMap<>();

        ArrayList<String> arteCultura = new ArrayList<>();
        arteCultura.add("Ar condicionado");
        arteCultura.add("Câmera");
        arteCultura.add("Computador");
        arteCultura.add("Eletrodomésticos");
        arteCultura.add("Eletrônicos");
        arteCultura.add("Outros");
        arteCultura.add("Tablets");
        arteCultura.add("Telefonia");

        ArrayList<String> arteCulturaFirebase = new ArrayList<>();
        arteCulturaFirebase.add("ar_condicionado");
        arteCulturaFirebase.add("camera");
        arteCulturaFirebase.add("computador");
        arteCulturaFirebase.add("eletrodomesticos");
        arteCulturaFirebase.add("eletronicos");
        arteCulturaFirebase.add("outros");
        arteCulturaFirebase.add("tablets");
        arteCulturaFirebase.add("telefonia");

        arteCulturaTelas.put(Utility.HASH_MAP_TELA, arteCultura);
        arteCulturaTelas.put(Utility.HASH_MAP_FIREBASE, arteCulturaFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_ARTE_CULTURA, arteCulturaTelas);

        HashMap<String, ArrayList<String>> aulasTelas = new HashMap<>();

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add("Ar condicionado");
        aulas.add("Câmera");
        aulas.add("Computador");
        aulas.add("Eletrodomésticos");
        aulas.add("Eletrônicos");
        aulas.add("Outros");
        aulas.add("Tablets");
        aulas.add("Telefonia");

        ArrayList<String> aulasFirebase = new ArrayList<>();
        aulasFirebase.add("ar_condicionado");
        aulasFirebase.add("camera");
        aulasFirebase.add("computador");
        aulasFirebase.add("eletrodomesticos");
        aulasFirebase.add("eletronicos");
        aulasFirebase.add("outros");
        aulasFirebase.add("tablets");
        aulasFirebase.add("telefonia");

        aulasTelas.put(Utility.HASH_MAP_TELA, aulas);
        aulasTelas.put(Utility.HASH_MAP_FIREBASE, aulasFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_AULAS, aulasTelas);

        HashMap<String, ArrayList<String>> autosTelas = new HashMap<>();

        ArrayList<String> autos = new ArrayList<>();
        autos.add("Ar condicionado");
        autos.add("Câmera");
        autos.add("Computador");
        autos.add("Eletrodomésticos");
        autos.add("Eletrônicos");
        autos.add("Outros");
        autos.add("Tablets");
        autos.add("Telefonia");

        ArrayList<String> autosFirebase = new ArrayList<>();
        autosFirebase.add("ar_condicionado");
        autosFirebase.add("camera");
        autosFirebase.add("computador");
        autosFirebase.add("eletrodomesticos");
        autosFirebase.add("eletronicos");
        autosFirebase.add("outros");
        autosFirebase.add("tablets");
        autosFirebase.add("telefonia");

        autosTelas.put(Utility.HASH_MAP_TELA, autos);
        autosTelas.put(Utility.HASH_MAP_FIREBASE, autosFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_AUTOS, autosTelas);

        HashMap<String, ArrayList<String>> belezaEsteticaTelas = new HashMap<>();

        ArrayList<String> belezaEstetica = new ArrayList<>();
        belezaEstetica.add("Ar condicionado");
        belezaEstetica.add("Câmera");
        belezaEstetica.add("Computador");
        belezaEstetica.add("Eletrodomésticos");
        belezaEstetica.add("Eletrônicos");
        belezaEstetica.add("Outros");
        belezaEstetica.add("Tablets");
        belezaEstetica.add("Telefonia");

        ArrayList<String> belezaEsteticaFirebase = new ArrayList<>();
        belezaEsteticaFirebase.add("ar_condicionado");
        belezaEsteticaFirebase.add("camera");
        belezaEsteticaFirebase.add("computador");
        belezaEsteticaFirebase.add("eletrodomesticos");
        belezaEsteticaFirebase.add("eletronicos");
        belezaEsteticaFirebase.add("outros");
        belezaEsteticaFirebase.add("tablets");
        belezaEsteticaFirebase.add("telefonia");

        belezaEsteticaTelas.put(Utility.HASH_MAP_TELA, belezaEstetica);
        belezaEsteticaTelas.put(Utility.HASH_MAP_FIREBASE, belezaEsteticaFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_BELEZA_ESTETICA, belezaEsteticaTelas);

        HashMap<String, ArrayList<String>> construcaoReformasTelas = new HashMap<>();

        ArrayList<String> construcaoReformas = new ArrayList<>();
        construcaoReformas.add("Ar condicionado");
        construcaoReformas.add("Câmera");
        construcaoReformas.add("Computador");
        construcaoReformas.add("Eletrodomésticos");
        construcaoReformas.add("Eletrônicos");
        construcaoReformas.add("Outros");
        construcaoReformas.add("Tablets");
        construcaoReformas.add("Telefonia");

        ArrayList<String> construcaoReformasFirebase = new ArrayList<>();
        construcaoReformasFirebase.add("ar_condicionado");
        construcaoReformasFirebase.add("camera");
        construcaoReformasFirebase.add("computador");
        construcaoReformasFirebase.add("eletrodomesticos");
        construcaoReformasFirebase.add("eletronicos");
        construcaoReformasFirebase.add("outros");
        construcaoReformasFirebase.add("tablets");
        construcaoReformasFirebase.add("telefonia");

        construcaoReformasTelas.put(Utility.HASH_MAP_TELA, construcaoReformas);
        construcaoReformasTelas.put(Utility.HASH_MAP_FIREBASE, construcaoReformasFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_CONSTRUCAO, construcaoReformasTelas);

        HashMap<String, ArrayList<String>> consultoriaTelas = new HashMap<>();

        ArrayList<String> consultoria = new ArrayList<>();
        consultoria.add("Ar condicionado");
        consultoria.add("Câmera");
        consultoria.add("Computador");
        consultoria.add("Eletrodomésticos");
        consultoria.add("Eletrônicos");
        consultoria.add("Outros");
        consultoria.add("Tablets");
        consultoria.add("Telefonia");

        ArrayList<String> consultoriaFirebase = new ArrayList<>();
        consultoriaFirebase.add("ar_condicionado");
        consultoriaFirebase.add("camera");
        consultoriaFirebase.add("computador");
        consultoriaFirebase.add("eletrodomesticos");
        consultoriaFirebase.add("eletronicos");
        consultoriaFirebase.add("outros");
        consultoriaFirebase.add("tablets");
        consultoriaFirebase.add("telefonia");

        consultoriaTelas.put(Utility.HASH_MAP_TELA, consultoria);
        consultoriaTelas.put(Utility.HASH_MAP_FIREBASE, consultoriaFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_CONSULTORIA, consultoriaTelas);

        HashMap<String, ArrayList<String>> designTecnologiaTelas = new HashMap<>();

        ArrayList<String> designTecnologia = new ArrayList<>();
        designTecnologia.add("Ar condicionado");
        designTecnologia.add("Câmera");
        designTecnologia.add("Computador");
        designTecnologia.add("Eletrodomésticos");
        designTecnologia.add("Eletrônicos");
        designTecnologia.add("Outros");
        designTecnologia.add("Tablets");
        designTecnologia.add("Telefonia");

        ArrayList<String> designTecnologiaFirebase = new ArrayList<>();
        designTecnologiaFirebase.add("ar_condicionado");
        designTecnologiaFirebase.add("camera");
        designTecnologiaFirebase.add("computador");
        designTecnologiaFirebase.add("eletrodomesticos");
        designTecnologiaFirebase.add("eletronicos");
        designTecnologiaFirebase.add("outros");
        designTecnologiaFirebase.add("tablets");
        designTecnologiaFirebase.add("telefonia");

        designTecnologiaTelas.put(Utility.HASH_MAP_TELA, designTecnologia);
        designTecnologiaTelas.put(Utility.HASH_MAP_FIREBASE, designTecnologiaFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_DESIGN, designTecnologiaTelas);

        HashMap<String, ArrayList<String>> eventosTelas = new HashMap<>();

        ArrayList<String> eventos = new ArrayList<>();
        eventos.add("Ar condicionado");
        eventos.add("Câmera");
        eventos.add("Computador");
        eventos.add("Eletrodomésticos");
        eventos.add("Eletrônicos");
        eventos.add("Outros");
        eventos.add("Tablets");
        eventos.add("Telefonia");

        ArrayList<String> eventosTelasFirebase = new ArrayList<>();
        eventosTelasFirebase.add("ar_condicionado");
        eventosTelasFirebase.add("camera");
        eventosTelasFirebase.add("computador");
        eventosTelasFirebase.add("eletrodomesticos");
        eventosTelasFirebase.add("eletronicos");
        eventosTelasFirebase.add("outros");
        eventosTelasFirebase.add("tablets");
        eventosTelasFirebase.add("telefonia");

        eventosTelas.put(Utility.HASH_MAP_TELA, eventos);
        eventosTelas.put(Utility.HASH_MAP_FIREBASE, eventosTelasFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_EVENTOS, eventosTelas);

        HashMap<String, ArrayList<String>> saudeTelas = new HashMap<>();

        ArrayList<String> saude = new ArrayList<>();
        saude.add("Ar condicionado");
        saude.add("Câmera");
        saude.add("Computador");
        saude.add("Eletrodomésticos");
        saude.add("Eletrônicos");
        saude.add("Outros");
        saude.add("Tablets");
        saude.add("Telefonia");

        ArrayList<String> saudeFirebase = new ArrayList<>();
        saudeFirebase.add("ar_condicionado");
        saudeFirebase.add("camera");
        saudeFirebase.add("computador");
        saudeFirebase.add("eletrodomesticos");
        saudeFirebase.add("eletronicos");
        saudeFirebase.add("outros");
        saudeFirebase.add("tablets");
        saudeFirebase.add("telefonia");

        saudeTelas.put(Utility.HASH_MAP_TELA, saude);
        saudeTelas.put(Utility.HASH_MAP_FIREBASE, saudeFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_SAUDE, saudeTelas);

        HashMap<String, ArrayList<String>> servicosDomesticosTelas = new HashMap<>();

        ArrayList<String> servicosDomesticos = new ArrayList<>();
        servicosDomesticos.add("Ar condicionado");
        servicosDomesticos.add("Câmera");
        servicosDomesticos.add("Computador");
        servicosDomesticos.add("Eletrodomésticos");
        servicosDomesticos.add("Eletrônicos");
        servicosDomesticos.add("Outros");
        servicosDomesticos.add("Tablets");
        servicosDomesticos.add("Telefonia");

        ArrayList<String> servicosDomesticosFirebase = new ArrayList<>();
        servicosDomesticosFirebase.add("ar_condicionado");
        servicosDomesticosFirebase.add("camera");
        servicosDomesticosFirebase.add("computador");
        servicosDomesticosFirebase.add("eletrodomesticos");
        servicosDomesticosFirebase.add("eletronicos");
        servicosDomesticosFirebase.add("outros");
        servicosDomesticosFirebase.add("tablets");
        servicosDomesticosFirebase.add("telefonia");

        servicosDomesticosTelas.put(Utility.HASH_MAP_TELA, servicosDomesticos);
        servicosDomesticosTelas.put(Utility.HASH_MAP_FIREBASE, servicosDomesticosFirebase);

        subcategoriasSegmentos.put(Utility.SEGMENTO_SERVICOS_DOMESTICOS, servicosDomesticosTelas);

        return subcategoriasSegmentos;
    }
}