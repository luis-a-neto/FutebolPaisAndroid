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

        /*String json = "[\n" +
                " {\n" +
                "  \"nome\": \"Espanhol\",\n" +
                "  \"gols\": \"19\",\n" +
                "  \"equipe\": \"Novorizontino\",\n" +
                "  \"numero\": \"30\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Corello\",\n" +
                "  \"gols\": \"18\",\n" +
                "  \"equipe\": \"Mirassol\",\n" +
                "  \"numero\": \"19\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"2\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Bello\",\n" +
                "  \"gols\": \"16\",\n" +
                "  \"equipe\": \"Mirassol\",\n" +
                "  \"numero\": \"17\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"1\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Jhonny\",\n" +
                "  \"gols\": \"15\",\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"numero\": \"9\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Sergio Ceni\",\n" +
                "  \"gols\": \"15\",\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"numero\": \"9\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Guti\",\n" +
                "  \"gols\": \"14\",\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"numero\": \"20\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Rippi\",\n" +
                "  \"gols\": \"14\",\n" +
                "  \"equipe\": \"Linense\",\n" +
                "  \"numero\": \"7\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Marinezio\",\n" +
                "  \"gols\": \"13\",\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"numero\": \"2\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Vellozo\",\n" +
                "  \"gols\": \"13\",\n" +
                "  \"equipe\": \"Linense\",\n" +
                "  \"numero\": \"11\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Armando\",\n" +
                "  \"gols\": \"12\",\n" +
                "  \"equipe\": \"Sao-Bento\",\n" +
                "  \"numero\": \"20\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Rainer\",\n" +
                "  \"gols\": \"11\",\n" +
                "  \"equipe\": \"Sao-Bento\",\n" +
                "  \"numero\": \"25\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Vulcano\",\n" +
                "  \"gols\": \"10\",\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"numero\": \"27\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Luigi\",\n" +
                "  \"gols\": \"10\",\n" +
                "  \"equipe\": \"Sao-Bento\",\n" +
                "  \"numero\": \"10\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Caio\",\n" +
                "  \"gols\": \"9\",\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"numero\": \"14\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Figueiredo\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Linense\",\n" +
                "  \"numero\": \"16\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Fabricio\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"numero\": \"10\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Léo\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"numero\": \"11\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Dunga\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"numero\": \"30\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Kito\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Novorizontino\",\n" +
                "  \"numero\": \"9\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Rogerio\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"numero\": \"10\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Fernando\",\n" +
                "  \"gols\": \"8\",\n" +
                "  \"equipe\": \"Novorizontino\",\n" +
                "  \"numero\": \"7\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Milton Bigucci\",\n" +
                "  \"gols\": \"7\",\n" +
                "  \"equipe\": \"Novorizontino\",\n" +
                "  \"numero\": \"10\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Sgambatti\",\n" +
                "  \"gols\": \"7\",\n" +
                "  \"equipe\": \"Red-Bull\",\n" +
                "  \"numero\": \"6\",\n" +
                "  \"posicao\": \"Volante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"1\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"João Carlos\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"numero\": \"20\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Airton\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Botafogo\",\n" +
                "  \"numero\": \"23\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Lerro\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"numero\": \"21\",\n" +
                "  \"posicao\": \"Meia\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"1\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Dudu\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Ferroviaria\",\n" +
                "  \"numero\": \"9\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Adriano\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Mirassol\",\n" +
                "  \"numero\": \"8\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Macedo\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Ponte-Preta\",\n" +
                "  \"numero\": \"15\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Ale Huertas\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Sao-Bento\",\n" +
                "  \"numero\": \"7\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"nome\": \"Paulinho\",\n" +
                "  \"gols\": \"6\",\n" +
                "  \"equipe\": \"Botafogo\",\n" +
                "  \"numero\": \"2\",\n" +
                "  \"posicao\": \"Atacante\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\"\n" +
                " }\n" +
                "]";*/

        //String json = "[]";

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
