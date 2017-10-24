package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.JogoDAO;
import br.com.futeboldospais.futeboldospais.model.Jogo;
import br.com.futeboldospais.futeboldospais.rest.JogoRest;

/**
 * Created by Daniel Almeida on 17/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class JogoService {

    private JogoDAO dao;
    private JogoRest jogoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public JogoService(){
        dao = new JogoDAO();
        jogoRest = new JogoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Jogo> getJogo(int campeonatoAno) throws Exception{

        List<Jogo> lista;

        String json = jogoRest.getJogo(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"08:00\"," +
                "  \"equipe1\": \"Westham\"," +
                "  \"equipe2\": \"Liverpool\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"10:00\"," +
                "  \"equipe1\": \"Park-Rangers\"," +
                "  \"equipe2\": \"Tottenham\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"12:00\"," +
                "  \"equipe1\": \"Manchester-United\"," +
                "  \"equipe2\": \"Fulham\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"14:00\"," +
                "  \"equipe1\": \"Arsenal\"," +
                "  \"equipe2\": \"Everton\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"19/10/2013\"," +
                "  \"horario\": \"16:00\"," +
                "  \"equipe1\": \"Manchester-City\"," +
                "  \"equipe2\": \"Newcastle\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"08:00\"," +
                "  \"equipe1\": \"Manchester-City\"," +
                "  \"equipe2\": \"Westham\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"10:00\"," +
                "  \"equipe1\": \"Park-Rangers\"," +
                "  \"equipe2\": \"Arsenal\"," +
                "  \"categoria\": \"Senior\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"12:00\"," +
                "  \"equipe1\": \"Liverpool\"," +
                "  \"equipe2\": \"Chelsea\"," +
                "  \"categoria\": \"Master\"" +
                " }," +
                " {" +
                "  \"rodada\": \"4\"," +
                "  \"turno\": \"2\"," +
                "  \"data\": \"26/10/2013\"," +
                "  \"horario\": \"14:00\"," +
                "  \"equipe1\": \"Everton\"," +
                "  \"equipe2\": \"Newcastle\"," +
                "  \"categoria\": \"Senior\"" +
                " }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Jogo>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Jogo passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Jogo> lista){
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
     * @param rodada Critério de busca, rodada do campeonato que se deseja buscar
     * @param turno Critério de busca, turno referente a rodada que se deseja buscar
     * @return Vetor de objeto do tipo Jogo
     */
    public Jogo[] listarDadosPorRodadaETurno(Context context, int rodada, int turno){
       return dao.listarDadosPorRodadaETurno(context, rodada, turno);
    }
}
