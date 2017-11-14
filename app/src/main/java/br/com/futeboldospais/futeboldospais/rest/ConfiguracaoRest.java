<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe rest
 */

public class ConfiguracaoRest {

    /**
     * @author Daniel Almeida
     * Método utilizado para baixar o conteúdo em formato json do arquivo de configuração no servidor
     * @return String no formato JSON
     * @throws Exception TimeoutException
     */
    public String getConfiguracaoServidor() throws Exception {

        String rs;

        String url = "http://www.futeboldospais.com.br/aplicativo/json/configuracaoes.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = response.body().string();
        }
        else{
            rs = null;
        }

        return rs;
    }
}
=======
package br.com.futeboldospais.futeboldospais.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe rest
 */

public class ConfiguracaoRest {

    /**
     * @author Daniel Almeida
     * Método utilizado para baixar o conteúdo em formato json do arquivo de configuração no servidor
     * @return String no formato JSON
     * @throws Exception TimeoutException
     */
    public String getConfiguracaoServidor() throws Exception {

        String rs;

        String url = "http://www.futeboldospais.com.br/config/config.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = response.body().string();
        }
        else{
            rs = null;
        }

        return rs;
    }
}
>>>>>>> repo-pamela/master
