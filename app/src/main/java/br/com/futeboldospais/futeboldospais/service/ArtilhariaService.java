package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.ArtilhariaDAO;
import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.rest.ArtilhariaRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 23/09/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ArtilhariaService {

    private ArtilhariaDAO dao;
    private ArtilhariaRest artilhariaRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ArtilhariaService(){
        dao = new ArtilhariaDAO();
        artilhariaRest = new ArtilhariaRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Artilharia> getArtilharia(int campeonatoAno) throws Exception{

        List<Artilharia> lista;

        String json = artilhariaRest.getArtilharia(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                "  {" +
                "   \"nome\": \"Corello\"," +
                "   \"gols\": \"16\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"19\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"cartoesAmarelos\": \"2\"," +
                "   \"cartoesVermelhos\": \"2\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Espanhol\"," +
                "   \"gols\": \"15\"," +
                "   \"equipe\": \"Novorizontino\"," +
                "   \"numero\": \"30\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Master\"," +
                "   \"cartoesAmarelos\": \"0\"," +
                "   \"cartoesVermelhos\": \"0\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Bello\"," +
                "   \"gols\": \"13\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"17\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Master\"," +
                "   \"cartoesAmarelos\": \"1\"," +
                "   \"cartoesVermelhos\": \"1\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Zezito\"," +
                "   \"gols\": \"12\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"10\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Master\"," +
                "   \"cartoesAmarelos\": \"0\"," +
                "   \"cartoesVermelhos\": \"0\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Joaozito\"," +
                "   \"gols\": \"10\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"10\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"cartoesAmarelos\": \"0\"," +
                "   \"cartoesVermelhos\": \"0\"" +
                "  }," +
                "  {" +
                "   \"nome\": \"Pedrito\"," +
                "   \"gols\": \"8\"," +
                "   \"equipe\": \"Mirassol\"," +
                "   \"numero\": \"10\"," +
                "   \"posicao\": \"Atacante\"," +
                "   \"categoria\": \"Senior\"," +
                "   \"cartoesAmarelos\": \"0\"," +
                "   \"cartoesVermelhos\": \"0\"" +
                "  }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Artilharia>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Artilharia passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Artilharia> lista){
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
     * @param categoria Critério de busca de artilharia de acordo com a categoria de jogo
     * @return Vetor de objeto do tipo Artilharia
     */
    public Artilharia[] listarDadosPorCategoria(Context context, String categoria){
        return dao.listarDadosPorCategoria(context, categoria);
    }
}
