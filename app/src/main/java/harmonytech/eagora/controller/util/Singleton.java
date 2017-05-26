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

        return subcategoriasSegmentos;
    }
}
