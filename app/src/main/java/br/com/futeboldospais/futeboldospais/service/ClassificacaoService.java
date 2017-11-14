<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.ClassificacaoDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.rest.ClassificacaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ClassificacaoService {

    private ClassificacaoDAO dao;
    private ClassificacaoRest classificacaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ClassificacaoService(){
        dao = new ClassificacaoDAO();
        classificacaoRest = new ClassificacaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Classificacao> getClassificacao(int campeonatoAno) throws Exception{

        List<Classificacao> lista;

        String json = classificacaoRest.getClassificacao(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[" +
                " {" +
                "  \"equipe\": \"Ferroviaria\"," +
                "  \"pontosGanhos\": \"74\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"17\"," +
                "  \"empates\": \"9\"," +
                "  \"derrotas\": \"5\"," +
                "  \"golsPro\": \"72\"," +
                "  \"golsContra\": \"45\"," +
                "  \"saldoGols\": \"27\"," +
                "  \"cartoesAmarelos\": \"35\"," +
                "  \"cartoesVermelhos\": \"3\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Linense\"," +
                "  \"pontosGanhos\": \"66\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"15\"," +
                "  \"empates\": \"5\"," +
                "  \"derrotas\": \"11\"," +
                "  \"golsPro\": \"56\"," +
                "  \"golsContra\": \"47\"," +
                "  \"saldoGols\": \"9\"," +
                "  \"cartoesAmarelos\": \"33\"," +
                "  \"cartoesVermelhos\": \"3\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Red-Bull\"," +
                "  \"pontosGanhos\": \"65\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"13\"," +
                "  \"empates\": \"8\"," +
                "  \"derrotas\": \"10\"," +
                "  \"golsPro\": \"60\"," +
                "  \"golsContra\": \"41\"," +
                "  \"saldoGols\": \"19\"," +
                "  \"cartoesAmarelos\": \"35\"," +
                "  \"cartoesVermelhos\": \"3\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Mirassol\"," +
                "  \"pontosGanhos\": \"64\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"13\"," +
                "  \"empates\": \"7\"," +
                "  \"derrotas\": \"11\"," +
                "  \"golsPro\": \"53\"," +
                "  \"golsContra\": \"62\"," +
                "  \"saldoGols\": \"-9\"," +
                "  \"cartoesAmarelos\": \"41\"," +
                "  \"cartoesVermelhos\": \"6\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Sao-Bento\"," +
                "  \"pontosGanhos\": \"62\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"11\"," +
                "  \"empates\": \"9\"," +
                "  \"derrotas\": \"11\"," +
                "  \"golsPro\": \"60\"," +
                "  \"golsContra\": \"59\"," +
                "  \"saldoGols\": \"1\"," +
                "  \"cartoesAmarelos\": \"46\"," +
                "  \"cartoesVermelhos\": \"1\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Ponte-Preta\"," +
                "  \"pontosGanhos\": \"59\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"11\"," +
                "  \"empates\": \"6\"," +
                "  \"derrotas\": \"14\"," +
                "  \"golsPro\": \"56\"," +
                "  \"golsContra\": \"65\"," +
                "  \"saldoGols\": \"-9\"," +
                "  \"cartoesAmarelos\": \"32\"," +
                "  \"cartoesVermelhos\": \"5\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Novorizontino\"," +
                "  \"pontosGanhos\": \"54\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"10\"," +
                "  \"empates\": \"3\"," +
                "  \"derrotas\": \"18\"," +
                "  \"golsPro\": \"53\"," +
                "  \"golsContra\": \"74\"," +
                "  \"saldoGols\": \"-21\"," +
                "  \"cartoesAmarelos\": \"37\"," +
                "  \"cartoesVermelhos\": \"1\"" +
                " }," +
                " {" +
                "  \"equipe\": \"Botafogo\"," +
                "  \"pontosGanhos\": \"52\"," +
                "  \"jogos\": \"31\"," +
                "  \"vitorias\": \"7\"," +
                "  \"empates\": \"7\"," +
                "  \"derrotas\": \"17\"," +
                "  \"golsPro\": \"45\"," +
                "  \"golsContra\": \"62\"," +
                "  \"saldoGols\": \"-17\"," +
                "  \"cartoesAmarelos\": \"37\"," +
                "  \"cartoesVermelhos\": \"4\"" +
                " }" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Classificacao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Classificacao passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista){
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
     * @return Vetor de objeto do tipo Classificacao
     */
    public Classificacao[] listarDados(Context context){
        return dao.listarDados(context);
    }

    public List<Classificacao> listarEquipes(Context context){
        return dao.listarEquipes(context);
    }
}
=======
package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import br.com.futeboldospais.futeboldospais.dao.ClassificacaoDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.rest.ClassificacaoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/09/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ClassificacaoService {

    private ClassificacaoDAO dao;
    private ClassificacaoRest classificacaoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ClassificacaoService(){
        dao = new ClassificacaoDAO();
        classificacaoRest = new ClassificacaoRest();
    }

    /**
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     */
    public List<Classificacao> getClassificacao(int campeonatoAno) throws Exception{

        List<Classificacao> lista;

        String json = classificacaoRest.getClassificacao(ConfiguracaoService.urlBase(campeonatoAno));

        /*String json = "[\n" +
                " {\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"pontosGanhos\": \"77\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"17\",\n" +
                "  \"empates\": \"10\",\n" +
                "  \"derrotas\": \"6\",\n" +
                "  \"golsPro\": \"75\",\n" +
                "  \"golsContra\": \"49\",\n" +
                "  \"saldoGols\": \"26\",\n" +
                "  \"cartoesAmarelos\": \"35\",\n" +
                "  \"cartoesVermelhos\": \"3\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"pontosGanhos\": \"71\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"15\",\n" +
                "  \"empates\": \"8\",\n" +
                "  \"derrotas\": \"10\",\n" +
                "  \"golsPro\": \"65\",\n" +
                "  \"golsContra\": \"44\",\n" +
                "  \"saldoGols\": \"21\",\n" +
                "  \"cartoesAmarelos\": \"38\",\n" +
                "  \"cartoesVermelhos\": \"3\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Linense\",\n" +
                "  \"pontosGanhos\": \"69\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"15\",\n" +
                "  \"empates\": \"6\",\n" +
                "  \"derrotas\": \"12\",\n" +
                "  \"golsPro\": \"57\",\n" +
                "  \"golsContra\": \"50\",\n" +
                "  \"saldoGols\": \"7\",\n" +
                "  \"cartoesAmarelos\": \"34\",\n" +
                "  \"cartoesVermelhos\": \"3\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Mirassol\",\n" +
                "  \"pontosGanhos\": \"68\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"14\",\n" +
                "  \"empates\": \"7\",\n" +
                "  \"derrotas\": \"12\",\n" +
                "  \"golsPro\": \"56\",\n" +
                "  \"golsContra\": \"64\",\n" +
                "  \"saldoGols\": \"-8\",\n" +
                "  \"cartoesAmarelos\": \"46\",\n" +
                "  \"cartoesVermelhos\": \"7\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"pontosGanhos\": \"65\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"13\",\n" +
                "  \"empates\": \"6\",\n" +
                "  \"derrotas\": \"14\",\n" +
                "  \"golsPro\": \"69\",\n" +
                "  \"golsContra\": \"68\",\n" +
                "  \"saldoGols\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"33\",\n" +
                "  \"cartoesVermelhos\": \"5\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Sao-Bento\",\n" +
                "  \"pontosGanhos\": \"64\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"11\",\n" +
                "  \"empates\": \"9\",\n" +
                "  \"derrotas\": \"13\",\n" +
                "  \"golsPro\": \"63\",\n" +
                "  \"golsContra\": \"68\",\n" +
                "  \"saldoGols\": \"-5\",\n" +
                "  \"cartoesAmarelos\": \"50\",\n" +
                "  \"cartoesVermelhos\": \"2\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Novorizontino\",\n" +
                "  \"pontosGanhos\": \"60\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"12\",\n" +
                "  \"empates\": \"3\",\n" +
                "  \"derrotas\": \"18\",\n" +
                "  \"golsPro\": \"59\",\n" +
                "  \"golsContra\": \"75\",\n" +
                "  \"saldoGols\": \"-16\",\n" +
                "  \"cartoesAmarelos\": \"39\",\n" +
                "  \"cartoesVermelhos\": \"2\"\n" +
                " },\n" +
                " {\n" +
                "  \"equipe\": \"Botafogo\",\n" +
                "  \"pontosGanhos\": \"54\",\n" +
                "  \"jogos\": \"33\",\n" +
                "  \"vitorias\": \"7\",\n" +
                "  \"empates\": \"7\",\n" +
                "  \"derrotas\": \"19\",\n" +
                "  \"golsPro\": \"46\",\n" +
                "  \"golsContra\": \"72\",\n" +
                "  \"saldoGols\": \"-26\",\n" +
                "  \"cartoesAmarelos\": \"38\",\n" +
                "  \"cartoesVermelhos\": \"4\"\n" +
                " }\n" +
                "]";*/

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Classificacao>>(){}.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     * @param lista ArrayList de Classificacao passado para a camada dao
     */
    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista){
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
     * @return Vetor de objeto do tipo Classificacao
     */
    public Classificacao[] listarDados(Context context){
        return dao.listarDados(context);
    }

    public List<Classificacao> listarEquipes(Context context){
        return dao.listarEquipes(context);
    }
}
>>>>>>> repo-pamela/master
