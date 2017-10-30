package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Cartao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class CartaoDAO {

    /**
     * @author Daniel Almeida
     * Metodo utilizado para gravar novos dados na tabela do banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @param listaCartaoAmarelo ArrayList de objetos passados para carregar as informações no ContentValues
     */
    public void inserirDadosCartaoAmarelo(SQLiteDatabase bd, List<Cartao> listaCartaoAmarelo) {

        ContentValues valores = new ContentValues();

        for (Cartao cartao : listaCartaoAmarelo) {
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_EQUIPE, cartao.getEquipe());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_NUMERO, cartao.getNumero());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_JOGADOR, cartao.getJogador());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_DATA, cartao.getData());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_TEMPO, cartao.getTempo());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ADVERSARIO, cartao.getAdversario());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ARBITRO, cartao.getArbitro());

            long id = bd.insert(BancoDados.Tabela.TABELA_CARTAO_AMARELO, null, valores);
        }
    }

    /**
     * @author Daniel Almeida
     * Metodo utilizado para gravar novos dados na tabela do banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @param listaCartaoVermelho ArrayList de objetos passados para carregar as informações no ContentValues
     */
    public void inserirDadosCartaoVermelho(SQLiteDatabase bd, List<Cartao> listaCartaoVermelho) {

        ContentValues valores = new ContentValues();

        for (Cartao cartao : listaCartaoVermelho) {
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_EQUIPE, cartao.getEquipe());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_NUMERO, cartao.getNumero());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_JOGADOR, cartao.getJogador());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_DATA, cartao.getData());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_TEMPO, cartao.getTempo());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ADVERSARIO, cartao.getAdversario());
            valores.put(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ARBITRO, cartao.getArbitro());

            long id = bd.insert(BancoDados.Tabela.TABELA_CARTAO_VERMELHO, null, valores);
        }
    }

    /**
     * @author Daniel Almeida
     * Metodo utilizado para deletar todos os dados da tabela no banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     */
    public void deletarDadosCartaoAmarelo(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_CARTAO_AMARELO, null, null);
    }

    /**
     * @author Daniel Almeida
     * Metodo utilizado para deletar todos os dados da tabela no banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     */
    public void deletarDadosCartaoVermelho(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_CARTAO_VERMELHO, null, null);
    }

    /**
     * @author Daniel Almeida
     * Este metodo serve para buscar o cadastro de cartões amarelos no banco
     * @param context Contexto da aplicação passado para obter conexão de leitura com o banco de dados
     * @return Retorna um vetor do tipo Cartao
     */
    public Cartao[] listarDadosCartaoAmarelo(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Cartao> retLista = new ArrayList<>();
        Cartao[] lista = null;
        Cartao cartao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_EQUIPE,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_NUMERO,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_JOGADOR,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_DATA,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_TEMPO,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ADVERSARIO,
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ARBITRO};

            String orderBy =
                    BancoDados.Tabela.COLUNA_CARTAO_AMARELO_DATA + " DESC";

            c = bd.query(BancoDados.Tabela.TABELA_CARTAO_AMARELO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    orderBy
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    cartao = new Cartao();
                    cartao.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_EQUIPE)));
                    cartao.setNumero(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_NUMERO)));
                    cartao.setJogador(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_JOGADOR)));
                    cartao.setData(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_DATA)));
                    cartao.setTempo(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_TEMPO)));
                    cartao.setAdversario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ADVERSARIO)));
                    cartao.setArbitro(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_AMARELO_ARBITRO)));

                    //Log.d("teste", cartao.toString());
                    retLista.add(cartao);
                }
                lista = retLista.toArray(new Cartao[0]);
            }
            else{
                lista = null;
            }
        } catch (Exception e) {
            lista = null;
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }

    /**
     * @author Daniel Almeida
     * Este metodo serve para buscar o cadastro de cartões vermelhos no banco
     * @param context Contexto de leitura passado para obter conexão com o banco de dados
     * @return Retorna um vetor do tipo Cartao
     */
    public Cartao[] listarDadosCartaoVermelho(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Cartao> retLista = new ArrayList<>();
        Cartao[] lista = null;
        Cartao cartao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_EQUIPE,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_NUMERO,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_JOGADOR,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_DATA,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_TEMPO,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ADVERSARIO,
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ARBITRO};

            String orderBy =
                    BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_DATA + " DESC";

            c = bd.query(BancoDados.Tabela.TABELA_CARTAO_VERMELHO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    orderBy
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    cartao = new Cartao();
                    cartao.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_EQUIPE)));
                    cartao.setNumero(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_NUMERO)));
                    cartao.setJogador(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_JOGADOR)));
                    cartao.setData(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_DATA)));
                    cartao.setTempo(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_TEMPO)));
                    cartao.setAdversario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ADVERSARIO)));
                    cartao.setArbitro(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CARTAO_VERMELHO_ARBITRO)));

                    Log.d("teste", cartao.toString());
                    retLista.add(cartao);
                }
                lista = retLista.toArray(new Cartao[0]);
            }
            else{
                lista = new Cartao[0];
            }
        } catch (Exception e) {
            lista = new Cartao[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }
}
