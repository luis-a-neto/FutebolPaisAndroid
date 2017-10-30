package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by ThirdSystem on 25/10/2017.
 */

public class GerenciadorDeConectividade {

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
