package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.CartaoDAO;
import br.com.futeboldospais.futeboldospais.model.Cartao;
import br.com.futeboldospais.futeboldospais.rest.CartaoRest;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class CartaoService {

    private CartaoDAO dao;
    private CartaoRest cartaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public CartaoService(){
        dao = new CartaoDAO();
        cartaoRest = new CartaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Cartao> getCartaoAmarelo(int campeonatoAno) throws Exception{

        List<Cartao> lista;

        String json = cartaoRest.getCartaoAmarelo(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"4\"," +
                "   \"jogador\": \"Adriano Helena\"," +
                "   \"data\": \"29/07/2017\"," +
                "   \"tempo\": \"89\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Marcos Silva Santos Gonçalves\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"8\"," +
                "   \"jogador\": \"Luis Claudio\"," +
                "   \"data\": \"20/08/2017\"," +
                "   \"tempo\": \"77\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Leandro Leão\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"9\"," +
                "   \"jogador\": \"Pina\"," +
                "   \"data\": \"12/03/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"Mirassol\"," +
                "   \"arbitro\": \"Marco Antônio\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Ferroviaria\"," +
                "   \"numero\": \"6\"," +
                "   \"jogador\": \"Elder Boy\"," +
                "   \"data\": \"21/05/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Cartao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Cartao> getCartaoVermelho(int campeonatoAno) throws Exception{

        List<Cartao> lista;

        String json = cartaoRest.getCartaoVermelho(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"4\"," +
                "   \"jogador\": \"Adriano Helena\"," +
                "   \"data\": \"29/07/2017\"," +
                "   \"tempo\": \"89\"," +
                "   \"adversario\": \"Novorizontino\"," +
                "   \"arbitro\": \"Marcos Silva Santos Gonçalves\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"8\"," +
                "   \"jogador\": \"Luis Claudio\"," +
                "   \"data\": \"20/08/2017\"," +
                "   \"tempo\": \"77\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Leandro Leão\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Botafogo\"," +
                "   \"numero\": \"9\"," +
                "   \"jogador\": \"Pina\"," +
                "   \"data\": \"12/03/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"Mirassol\"," +
                "   \"arbitro\": \"Marco Antônio\"" +
                "  }," +
                "  {" +
                "   \"equipe\": \"Ferroviaria\"," +
                "   \"numero\": \"6\"," +
                "   \"jogador\": \"Elder Boy\"," +
                "   \"data\": \"21/05/2017\"," +
                "   \"tempo\": \"90\"," +
                "   \"adversario\": \"São Bento\"," +
                "   \"arbitro\": \"Vladimir Vassoler\"" +
                "  }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Cartao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param listaCartaoAmarelo ArrayList de Cartao contendo os cartoes amarelos passado para a camada dao
     * @param listaCartaoVermelho ArrayList de Cartao contendo os cartoes vermelhos passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Cartao> listaCartaoAmarelo, List<Cartao> listaCartaoVermelho){
        dao.inserirDadosCartaoAmarelo(bd, listaCartaoAmarelo);
        dao.inserirDadosCartaoVermelho(bd, listaCartaoVermelho);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     */
    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDadosCartaoAmarelo(bd);
        dao.deletarDadosCartaoVermelho(bd);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Cartao
     */
    public Cartao[] listarDadosCartaoaAmarelo(Context context){
        return dao.listarDadosCartaoAmarelo(context);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Cartao
     */
    public Cartao[] listarDadosCartaoVermelho(Context context){
        return dao.listarDadosCartaoVermelho(context);
    }
}
