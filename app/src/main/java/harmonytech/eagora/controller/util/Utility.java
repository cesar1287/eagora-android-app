package harmonytech.eagora.controller.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;

import harmonytech.eagora.R;

public class Utility {

    public static final String URI_PACKAGE = "android.resource://harmonytech.eagora/";

    public static final String SEGMENTO = "segmento";
    public static final String SEGMENTO_FIREBASE = "segmentoFirebase";

    public static final String SEGMENTO_ANIMAIS = "Animais";
    public static final String SEGMENTO_ARTE_CULTURA = "Arte e Cultura";
    public static final String SEGMENTO_ASSISTENCIA_TECNICA = "Assistência Técnica";
    public static final String SEGMENTO_ASSISTENCIA_TECNICA_FIREBASE = "assistenciaTecnica";
    public static final String SEGMENTO_AULAS = "Aulas";
    public static final String SEGMENTO_AUTOS = "Autos";
    public static final String SEGMENTO_BELEZA_ESTETICA = "Beleza e Estética";
    public static final String SEGMENTO_CONSTRUCAO = "Construção e Reformas";
    public static final String SEGMENTO_CONSULTORIA = "Consultoria";
    public static final String SEGMENTO_DESIGN = "Design e Tecnologia";
    public static final String SEGMENTO_EVENTOS = "Eventos";
    public static final String SEGMENTO_SAUDE = "Saúde";
    public static final String SEGMENTO_SERVICOS_DOMESTICOS = "Serviços Domésticos";

    public static final String HASH_MAP_TELA = "tela";
    public static final String HASH_MAP_FIREBASE = "firebase";

    public static final String SEGMENT_DETAILS_TITLE = "title";

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
            digito = Integer.parseInt(str.substring(indice,indice+1));
            soma += digito*peso[peso.length-str.length()+indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf==null) || (cpf.length()!=11)) return false;

        Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
    }

    public static boolean isConnected(Activity activity){
        ConnectivityManager cm =
                (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public static void showSnackBarErrorMessage(Activity activity, String errorMessage){

        TSnackbar snackbar = TSnackbar.make(activity.findViewById(android.R.id.content), errorMessage, TSnackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.redNoInternetConnection));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }

    public static void showSnackBarSucessMessage(Activity activity, String sucessMessage){

        TSnackbar snackbar = TSnackbar.make(activity.findViewById(android.R.id.content), sucessMessage, TSnackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(activity.getResources().getColor(R.color.greenSucessMessage));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }

    public static String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    public static TextWatcher insertMask(final String mask, final EditText ediTxt) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                String str = unmask(s.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                ediTxt.setText(mascara);
                ediTxt.setSelection(mascara.length());
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        };
    }
}
