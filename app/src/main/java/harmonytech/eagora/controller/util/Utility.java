package harmonytech.eagora.controller.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Gravity;
import android.view.View;
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
}
