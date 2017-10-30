package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Suspensao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class SuspensaoDAO {

    /**
     * @author Daniel Almeida
     * Metodo utilizado para gravar novos dados na tabela do banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @param lista ArrayList de objetos passados para carregar as informações no ContentValues
     */
    public void inserirDados(SQLiteDatabase bd, List<Suspensao> lista) {

        ContentValues valores = new ContentValues();

        for (Suspensao suspensao : lista) {
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_EQUIPE, suspensao.getEquipe());
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_JOGADOR, suspensao.getJogador());
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_NUMERO, suspensao.getNumero());
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_CATEGORIA, suspensao.getCategoria());
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_JOGOS, suspensao.getJogos());
            valores.put(BancoDados.Tabela.COLUNA_SUSPENSAO_MOTIVO, suspensao.getMotivo());

            long id = bd.insert(BancoDados.Tabela.TABELA_SUSPENSAO, null, valores);
        }
    }

    /**
     * @author Daniel Almeida
     * Metodo utilizado para deletar todos os dados da tabela no banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     */
    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_SUSPENSAO, null, null);
    }

    /**
     * @author Daniel Almeida
     * Este metodo serve para buscar o cadastro de suspensões no banco
     * @param context Contexto da aplicação passado para obter conexão de leitura com o banco de dados
     * @return Retorna um vetor do tipo Suspensao
     */
    public Suspensao[] listarDados(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Suspensao> retLista = new ArrayList<>();
        Suspensao[] lista = null;
        Suspensao suspensao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_EQUIPE,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_JOGADOR,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_NUMERO,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_CATEGORIA,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_JOGOS,
                    BancoDados.Tabela.COLUNA_SUSPENSAO_MOTIVO};

            c = bd.query(BancoDados.Tabela.TABELA_SUSPENSAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    suspensao = new Suspensao();
                    suspensao.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_EQUIPE)));
                    suspensao.setJogador(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_JOGADOR)));
                    suspensao.setNumero(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_NUMERO)));
                    suspensao.setCategoria(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_CATEGORIA)));
                    suspensao.setJogos(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_JOGOS)));
                    suspensao.setMotivo(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_SUSPENSAO_MOTIVO)));

                    Log.d("teste", suspensao.toString());
                    retLista.add(suspensao);
                }
                lista = retLista.toArray(new Suspensao[0]);
            }
            else{
                lista = new Suspensao[0];
            }
        } catch (Exception e) {
            lista = new Suspensao[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }
}
