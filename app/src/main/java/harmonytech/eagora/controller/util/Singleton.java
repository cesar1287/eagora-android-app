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

    public HashMap<String, ArrayList<String>> getSegmentos(){

        HashMap<String, ArrayList<String>> subcategoriasSegmentos = new HashMap<>();

        ArrayList<String> assistenciaTecnica = new ArrayList<>();
        assistenciaTecnica.add("Ar condicionado");
        assistenciaTecnica.add("Câmera");
        assistenciaTecnica.add("Computador");
        assistenciaTecnica.add("Eletrodomésticos");
        assistenciaTecnica.add("Eletrônicos");
        assistenciaTecnica.add("Outros");
        assistenciaTecnica.add("Tablets");
        assistenciaTecnica.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_ASSISTENCIA_TECNICA, assistenciaTecnica);

        ArrayList<String> animais = new ArrayList<>();
        animais.add("Ar condicionado");
        animais.add("Câmera");
        animais.add("Computador");
        animais.add("Eletrodomésticos");
        animais.add("Eletrônicos");
        animais.add("Outros");
        animais.add("Tablets");
        animais.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_ANIMAIS, animais);

        ArrayList<String> arteCultura = new ArrayList<>();
        arteCultura.add("Ar condicionado");
        arteCultura.add("Câmera");
        arteCultura.add("Computador");
        arteCultura.add("Eletrodomésticos");
        arteCultura.add("Eletrônicos");
        arteCultura.add("Outros");
        arteCultura.add("Tablets");
        arteCultura.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_ARTE_CULTURA, arteCultura);

        ArrayList<String> aulas = new ArrayList<>();
        aulas.add("Ar condicionado");
        aulas.add("Câmera");
        aulas.add("Computador");
        aulas.add("Eletrodomésticos");
        aulas.add("Eletrônicos");
        aulas.add("Outros");
        aulas.add("Tablets");
        aulas.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_AULAS, aulas);

        ArrayList<String> autos = new ArrayList<>();
        autos.add("Ar condicionado");
        autos.add("Câmera");
        autos.add("Computador");
        autos.add("Eletrodomésticos");
        autos.add("Eletrônicos");
        autos.add("Outros");
        autos.add("Tablets");
        autos.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_AUTOS, autos);

        ArrayList<String> belezaEstetica = new ArrayList<>();
        belezaEstetica.add("Ar condicionado");
        belezaEstetica.add("Câmera");
        belezaEstetica.add("Computador");
        belezaEstetica.add("Eletrodomésticos");
        belezaEstetica.add("Eletrônicos");
        belezaEstetica.add("Outros");
        belezaEstetica.add("Tablets");
        belezaEstetica.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_BELEZA_ESTETICA, belezaEstetica);

        ArrayList<String> construcaoReformas = new ArrayList<>();
        construcaoReformas.add("Ar condicionado");
        construcaoReformas.add("Câmera");
        construcaoReformas.add("Computador");
        construcaoReformas.add("Eletrodomésticos");
        construcaoReformas.add("Eletrônicos");
        construcaoReformas.add("Outros");
        construcaoReformas.add("Tablets");
        construcaoReformas.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_CONSTRUCAO, construcaoReformas);

        ArrayList<String> consultoria = new ArrayList<>();
        consultoria.add("Ar condicionado");
        consultoria.add("Câmera");
        consultoria.add("Computador");
        consultoria.add("Eletrodomésticos");
        consultoria.add("Eletrônicos");
        consultoria.add("Outros");
        consultoria.add("Tablets");
        consultoria.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_CONSULTORIA, consultoria);

        ArrayList<String> designTecnologia = new ArrayList<>();
        designTecnologia.add("Ar condicionado");
        designTecnologia.add("Câmera");
        designTecnologia.add("Computador");
        designTecnologia.add("Eletrodomésticos");
        designTecnologia.add("Eletrônicos");
        designTecnologia.add("Outros");
        designTecnologia.add("Tablets");
        designTecnologia.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_DESIGN, designTecnologia);

        ArrayList<String> eventos = new ArrayList<>();
        eventos.add("Ar condicionado");
        eventos.add("Câmera");
        eventos.add("Computador");
        eventos.add("Eletrodomésticos");
        eventos.add("Eletrônicos");
        eventos.add("Outros");
        eventos.add("Tablets");
        eventos.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_EVENTOS, eventos);

        ArrayList<String> saude = new ArrayList<>();
        saude.add("Ar condicionado");
        saude.add("Câmera");
        saude.add("Computador");
        saude.add("Eletrodomésticos");
        saude.add("Eletrônicos");
        saude.add("Outros");
        saude.add("Tablets");
        saude.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_SAUDE, saude);

        ArrayList<String> servicosDomesticos = new ArrayList<>();
        servicosDomesticos.add("Ar condicionado");
        servicosDomesticos.add("Câmera");
        servicosDomesticos.add("Computador");
        servicosDomesticos.add("Eletrodomésticos");
        servicosDomesticos.add("Eletrônicos");
        servicosDomesticos.add("Outros");
        servicosDomesticos.add("Tablets");
        servicosDomesticos.add("Telefonia");

        subcategoriasSegmentos.put(Utility.SEGMENTO_SERVICOS_DOMESTICOS, servicosDomesticos);

        return subcategoriasSegmentos;
    }
}
