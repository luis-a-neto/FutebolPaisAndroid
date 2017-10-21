package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.net.ConnectivityManager;

import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

/**
    Projeto:    FutebolPaisAndroid
    Arquivo:    FileDownloadHelper.java
    Autor:      Luis Andrade
    Data:       24.09.2017

    Um helper para baixar arquivos. Reutilizável, para permitir o download dos JSONs e de outros
    arquivos. Oferece ainda um verificador de conectividade.
    Deve-se utilizar os métodos downloadText (para baixar arquivos de texto -- p. ex., JSONs) e
    downloadBinary (para baixar outros tipos de arquivo). Ambos devem receber como argumento o
    contexto da aplicação e o URI a ser baixado.
    O método checkConnectivity retorna um boolean -- true se houver conexão, false se não houver.
    Recebe apenas o contexto como argumento.

    Dependências: com.squareup.okhttp:okhttp:2.5.0 (adicionar ao build.gradle).

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

    private static ResponseBody downloadFile(Context context, String uri) throws Exception {
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
