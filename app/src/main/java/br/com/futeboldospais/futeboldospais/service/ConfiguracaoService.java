package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import br.com.futeboldospais.futeboldospais.dao.ConfiguracaoDAO;
import br.com.futeboldospais.futeboldospais.model.Configuracao;
import br.com.futeboldospais.futeboldospais.rest.ConfiguracaoRest;

/**
 * Created by Daniel Almeida on 09/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ConfiguracaoService {

    private ConfiguracaoDAO dao;
    private ConfiguracaoRest configuracaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ConfiguracaoService() {
        dao = new ConfiguracaoDAO();
        configuracaoRest = new ConfiguracaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um json no formato String e
     * faz a sua conversão para objeto java utilizando reflexão
     * @return Um objeto Configuração parseado de um JSONObject
     * @throws Exception JSONException
     */
    public Configuracao getConfiguracaoServidor() throws Exception {

        Configuracao configuracao;

        //String json = configuracaoRest.getConfiguracaoServidor();

        String json = "{" +
                "\"campeonatoAno\":\"2017\"," +
                "\"versao\":\"1\"" +
                "}";

        Gson gson = new Gson();

        configuracao = gson.fromJson(json, Configuracao.class);

        return configuracao;
    }

    public static String urlBase(int campeonatoAno){
        String urlBase = "http://www.futeboldospais.com.br/campeonato" + String.valueOf(campeonatoAno) + "/json/";
        return urlBase;
    }

    public void atualizarVersaoLocal(SQLiteDatabase bd, Configuracao configuracao, int versaoLocal) {
        dao.atualizarVersaoLocal(bd, configuracao, versaoLocal);
    }

    public int getVersaoLocal(Context context) {
        return dao.getVersaoLocal(context);
    }

    public int getCampeonatoAnoLocal(Context context){
        return dao.getCampeonatoAnoLocal(context);
    }

    public String getUltimaAtualizacao(Context context) {
        return dao.getUltimaAtualizacao(context);
    }
}
