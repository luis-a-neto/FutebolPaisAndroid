package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import java.io.InputStream;

/**
    Projeto:    FutebolPaisAndroid
    Arquivo:    FileDownloadHelper.java
    Autor:      Luis Andrade
    Data:       24.09.2017

    Uma helper thread para baixar arquivos. Reutilizável, para permitir o download dos JSONs
    e de outros arquivos. Oferece ainda um verificador de conectividade.

    Histórico de modificações:
    Data ______ Autor _________________ Resumo ___________________________________________________
    24.09.2017  Luis Andrade            Inicial
 */

public class FileDownloadHelper {

    public static boolean checkConnectivity(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public static ResponseBody downloadFile(Context context, String uri) throws Exception {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(uri).build();
            return client.newCall(request).execute().body();
    }

    public static String downloadText(Context context, String uri) throws Exception {
        return downloadFile(context, uri).string();
    }

    public static InputStream downloadBinary(Context context, String uri) throws Exception {
        return downloadFile(context, uri).byteStream();
    }
}
