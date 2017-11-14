package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.ResultadoDAO;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.rest.ResultadoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ResultadoService {

    private ResultadoDAO dao;
    private ResultadoRest resultadoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ResultadoService(){
        dao = new ResultadoDAO();
        resultadoRest = new ResultadoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Resultado> getResultado(int campeonatoAno) throws Exception{

        List<Resultado> lista;

        String json = resultadoRest.getResultado(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                " {" +
                "  \"data\": \"04/03/2017\"," +
                "  \"horario\": \"08:30\"," +
                "  \"equipe1\": \"Linense\"," +
                "  \"golsEquipe1\": \"1\"," +
                "  \"equipe2\": \"Mirassol\"," +
                "  \"golEquipe2\": \"4\"," +
                "  \"cartoesAmarelos\": \"3\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"3\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Jacildo Antonio de Paula\"," +
                "  \"assistente1\": \"Carlos Alberto Farias\"," +
                "  \"assistente2\": \"Eliton Lopes\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"04/03/2017\"," +
                "  \"horario\": \"10:30\"," +
                "  \"equipe1\": \"Linense\"," +
                "  \"golsEquipe1\": \"0\"," +
                "  \"equipe2\": \"Mirassol\"," +
                "  \"golsEquipe2\": \"2\"," +
                "  \"cartoesAmarelos\": \"0\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"0\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Carlos Alberto Farias\"," +
                "  \"assistente1\": \"Giovanni Crescencio\"," +
                "  \"assistente2\": \"Eliton Lopes\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"10\"," +
                "  \"notaArbitroEquipe2\": \"8\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"04/03/2017\"," +
                "  \"horario\": \"12:30\"," +
                "  \"equipe1\": \"Botafogo\"," +
                "  \"golsEquipe1\": \"1\"," +
                "  \"equipe2\": \"Ferroviaria\"," +
                "  \"golsEquipe2\": \"1\"," +
                "  \"cartoesAmarelos\": \"3\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"3\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Jacildo Antonio de Paula\"," +
                "  \"assistente1\": \"Giovanni Crescencio\"," +
                "  \"assistente2\": \"Eliton Lopes\"," +
                "  \"notaArbitroMedia\": \"8\"," +
                "  \"notaArbitroEquipe1\": \"7\"," +
                "  \"notaArbitroEquipe2\": \"8\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"04/03/2017\"," +
                "  \"horario\": \"14:30\"," +
                "  \"equipe1\": \"Botafogo\"," +
                "  \"golsEquipe1\": \"0\"," +
                "  \"equipe2\": \"Ferroviaria\"," +
                "  \"golsEquipe2\": \"1\"," +
                "  \"cartoesAmarelos\": \"3\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"3\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Carlos Alberto Farias\"," +
                "  \"assistente1\": \"Jacildo Antonio de Paula\"," +
                "  \"assistente2\": \"Giovanni Crescencio\"," +
                "  \"notaArbitro-media\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"05/03/2017\"," +
                "  \"horario\": \"09:00\"," +
                "  \"equipe1\": \"Novorizontino\"," +
                "  \"golsEquipe1\": \"2\"," +
                "  \"equipe2\": \"Ponte-Preta\"," +
                "  \"golsEquipe2\": \"1\"," +
                "  \"cartoesAmarelos\": \"3\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"3\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Wagner Rizo\"," +
                "  \"assistente1\": \"Marco Motta\"," +
                "  \"assistente2\": \"Willians Vilela\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"05/03/2017\"," +
                "  \"horario\": \"11:00\"," +
                "  \"equipe1\": \"Novorizontino\"," +
                "  \"golsEquipe1\": \"3\"," +
                "  \"equipe2\": \"Ponte-Preta\"," +
                "  \"golsEquipe2\": \"2\"," +
                "  \"cartoesAmarelos\": \"1\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"1\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Marco Motta\"," +
                "  \"assistente1\": \"Wagner Rizo\"," +
                "  \"assistente2\": \"Willians Vilela\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"1\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"11/03/2017\"," +
                "  \"horario\": \"08:30\"," +
                "  \"equipe1\": \"Red-Bull\"," +
                "  \"golsEquipe1\": \"3\"," +
                "  \"equipe2\": \"Sao-Bento\"," +
                "  \"golsEquipe2\": \"5\"," +
                "  \"cartoesAmarelos\": \"2\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"2\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Alexandre Augusto\"," +
                "  \"assistente1\": \"José Jenilton Santos\"," +
                "  \"assistente2\": \"Lohan Alves dos Santos\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"8\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"11/03/2017\"," +
                "  \"horario\": \"10:30\"," +
                "  \"equipe1\": \"Red-Bull\"," +
                "  \"golsEquipe1\": \"0\"," +
                "  \"equipe2\": \"Sao-Bento\"," +
                "  \"golsEquipe2\": \"0\"," +
                "  \"cartoesAmarelos\": \"2\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"2\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Vladimir Vassoler\"," +
                "  \"assistente1\": \"José Jenilton Santos\"," +
                "  \"assistente2\": \"Alexandre Augusto\"," +
                "  \"notaArbitroMedia\": \"8\"," +
                "  \"notaArbitroEquipe1\": \"8\"," +
                "  \"notaArbitroEquipe2\": \"8\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"11/03/2017\"," +
                "  \"horario\": \"12:30\"," +
                "  \"equipe1\": \"Linense\"," +
                "  \"golsEquipe1\": \"5\"," +
                "  \"equipe2\": \"Ponte-Preta\"," +
                "  \"golsEquipe2\": \"0\"," +
                "  \"cartoesAmarelos\": \"2\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"2\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Alexandre Augusto\"," +
                "  \"assistente1\": \"José Jenilton Santos\"," +
                "  \"assistente2\": \"Lohan Alves dos Santos\"," +
                "  \"notaArbitroMedia\": \"10\"," +
                "  \"notaArbitroEquipe1\": \"10\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"11/03/2017\"," +
                "  \"horario\": \"14:30\"," +
                "  \"equipe1\": \"Linense\"," +
                "  \"golsEquipe1\": \"0\"," +
                "  \"equipe2\": \"Ponte-Preta\"," +
                "  \"golsEquipe2\": \"1\"," +
                "  \"cartoesAmarelos\": \"1\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"1\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Vladimir Vassoler\"," +
                "  \"assistente1\": \"Lohan Alves dos Santos\"," +
                "  \"assistente2\": \"José Jenilton Santos\"," +
                "  \"notaArbitroMedia\": \"10\"," +
                "  \"notaArbitroEquipe1\": \"10\"," +
                "  \"notaArbitroEquipe2\": \"10\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"12/03/2017\"," +
                "  \"horario\": \"09:00\"," +
                "  \"equipe1\": \"Botafogo\"," +
                "  \"golsEquipe1\": \"3\"," +
                "  \"equipe2\": \"Mirassol\"," +
                "  \"golsEquipe2\": \"3\"," +
                "  \"cartoesAmarelos\": \"6\"," +
                "  \"cartoesVermelhos\": \"4\"," +
                "  \"totalCartoes\": \"10\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Marco Antônio Pereira Camargo\"," +
                "  \"assistente1\": \"Antônio Carlos L. Mendes\"," +
                "  \"assistente2\": \"Adriana de Almeida\"," +
                "  \"notaArbitroMedia\": \"6\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"3\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"12/03/2017\"," +
                "  \"horario\": \"11:00\"," +
                "  \"equipe1\": \"Botafogo\"," +
                "  \"golsEquipe1\": \"6\"," +
                "  \"equipe2\": \"Mirassol\"," +
                "  \"golsEquipe2\": \"0\"," +
                "  \"cartoesAmarelos\": \"0\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"0\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Adriana de Almeida\"," +
                "  \"assistente1\": \"Antônio Carlos L. Mendes\"," +
                "  \"assistente2\": \"Marco Antônio Pereira Camargo\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"2\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"18/03/2017\"," +
                "  \"horario\": \"08:30\"," +
                "  \"equipe1\": \"Red-Bull\"," +
                "  \"golsEquipe1\": \"1\"," +
                "  \"equipe2\": \"Ferroviaria\"," +
                "  \"golsEquipe2\": \"2\"," +
                "  \"cartoesAmarelos\": \"0\"," +
                "  \"cartoesVermelhos\": \"0\"," +
                "  \"totalCartoes\": \"0\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Márcio Bastos\"," +
                "  \"assistente1\": \"Marcos Silva Santos Gonçalves\"," +
                "  \"assistente2\": \"Guilherme Nunes\"," +
                "  \"notaArbitroMedia\": \"10\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"10\"," +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"18/03/2017\"," +
                "  \"horario\": \"10:30\"," +
                "  \"equipe1\": \"Red-Bull\"," +
                "  \"golsEquipe1\": \"1\"," +
                "  \"equipe2\": \"Ferroviaria\"," +
                "  \"golsEquipe2\": \"1\"," +
                "  \"cartoesAmarelos\": \"2\"," +
                "  \"cartoesVermelhos\": \"1\"," +
                "  \"totalCartoes\": \"3\"," +
                "  \"categoria\": \"Senior\"," +
                "  \"arbitro\": \"Marcos Silva Santos Gonçalves\"," +
                "  \"assistente1\": \"Robson Ferreira\"," +
                "  \"assistente2\": \"Márcio Bastos\"," +
                "  \"notaArbitroMedia\": \"9\"," +
                "  \"notaArbitroEquipe1\": \"9\"," +
                "  \"notaArbitroEquipe2\": \"9\"," +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"" +
                " }," +
                " {" +
                "  \"data\": \"18/03/2017\"," +
                "  \"horario\": \"12:30\"," +
                "  \"equipe1\": \"Novorizontino\"," +
                "  \"golsEquipe1\": \"2\"," +
                "  \"equipe2\": \"Sao-Bento\"," +
                "  \"golsEquipe2\": \"3\"," +
                "  \"cartoesAmarelos\": \"1\"," +
                "  \"cartoesAermelhos\": \"0\"," +
                "  \"totalCartoes\": \"1\"," +
                "  \"categoria\": \"Master\"," +
                "  \"arbitro\": \"Guilherme Nunes\"," +
                "  \"assistente1\": \"Robson Ferreira\"," +
                "  \"assistente2\": \"Márcio Bastos\"," +
                "  \"notaArbitroMedia\": \"8\"," +
                "  \"notaArbitroEquipe1\": \"7\"," +
                "  \"notaArbitroEquipe2\": \"8\"," +
                "  \"rodada\": \"3\"," +
                "  \"turno\": \"1\"" +
                " }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Resultado>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Resultado passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Resultado> lista){
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
     * @return Vetor de objeto do tipo Resultado
     */
    public Resultado[] listarDadosPorRodadaETurno(Context context, int rodada, int turno){
        return dao.listarDadosPorRodadaETurno(context, rodada, turno);
    }
}
