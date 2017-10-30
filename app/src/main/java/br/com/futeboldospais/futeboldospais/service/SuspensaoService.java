package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.SuspensaoDAO;
import br.com.futeboldospais.futeboldospais.model.Suspensao;
import br.com.futeboldospais.futeboldospais.rest.SuspensaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class SuspensaoService {

    private SuspensaoDAO dao;
    private SuspensaoRest suspensaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public SuspensaoService(){
        dao = new SuspensaoDAO();
        suspensaoRest = new SuspensaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Suspensao> getSuspensao(int campeonatoAno) throws Exception{

        List<Suspensao> lista;

        String json = suspensaoRest.getSuspensao(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                "  {" +
                "   \"equipe\": \"Ponte Preta\"," +
                "   \"jogador\": \"Amaro\"," +
                "   \"numero\": \"10\"," +
                "   \"categoria\": \"Master\"," +
                "   \"criterio\": \"1\"," +
                "   \"jogos\": \"1/1\"," +
                "   \"motivo\": \"Cartao Vermelho\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"jogador\": \"Pina\"," +
                "   \"numero\": \"9\"," +
                "   \"categoria\": \"Master\"," +
                "   \"criterio\": \"1\"," +
                "   \"jogos\": \"1/2\"," +
                "   \"motivo\": \"Cartao Vermelho\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"São Bento\"," +
                "   \"jogador\": \"Nelson\"," +
                "   \"numero\": \"23\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"criterio\": \"1\"," +
                "   \"jogos\": \"1/1\"," +
                "   \"motivo\": \"3 Cartões Amarelos\"" +
                "  }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Suspensao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Suspensao passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Suspensao> lista){
        dao.inserirDados(bd, lista);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     */
    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Suspensao
     */
    public Suspensao[] listarDados(Context context){
        return dao.listarDados(context);
    }
}
