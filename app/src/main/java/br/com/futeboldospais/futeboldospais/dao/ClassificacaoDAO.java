package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Classificacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Almeida on 12/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class ClassificacaoDAO {

    /**
     * @param bd    Conexão de gravação passada para execução do comando SQL
     * @param lista ArrayList de objetos passados para carregar as informações no ContentValues
     * @author Daniel Almeida
     * Metodo utilizado para gravar novos dados na tabela do banco de dados
     */
    public void inserirDados(SQLiteDatabase bd, List<Classificacao> lista) {

        ContentValues valores = new ContentValues();

        for (Classificacao classificacao : lista) {
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_EQUIPE, classificacao.getEquipe());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS, classificacao.getPontosGanhos());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS, classificacao.getJogos());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS, classificacao.getVitorias());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS, classificacao.getSaldoGols());

            long id = bd.insert(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, valores);
        }
    }

    /**
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @author Daniel Almeida
     * Metodo utilizado para deletar todos os dados da tabela no banco de dados
     */
    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_CLASSIFICACAO, null, null);
    }

    /**
     * @param context Contexto da aplicação passado para obter conexão de leitura com o banco de dados
     * @return Retorna um vetor do tipo Classificacao
     * @author Daniel Almeida
     * Este metodo serve para buscar o cadastro da clasificação geral no banco
     */
    public Classificacao[] listarDados(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Classificacao> retLista = new ArrayList<>();
        Classificacao[] lista = null;
        Classificacao classificacao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_EQUIPE,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS};

            c = bd.query(BancoDados.Tabela.TABELA_CLASSIFICACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.getCount() != 0) {
                while (c.moveToNext()) {
                    classificacao = new Classificacao();
                    classificacao.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_EQUIPE)));
                    classificacao.setPontosGanhos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_PONTOS_GANHOS)));
                    classificacao.setJogos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_JOGOS)));
                    classificacao.setVitorias(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_VITORIAS)));
                    classificacao.setSaldoGols(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_SALDO_GOLS)));

                    Log.d("teste", classificacao.toString());
                    retLista.add(classificacao);
                }
                lista = retLista.toArray(new Classificacao[0]);
            } else {
                lista = new Classificacao[0];
            }
        } catch (Exception e) {
            lista = new Classificacao[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }

    public List<Classificacao> listarEquipes(Context context) {
        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Classificacao> lista = new ArrayList<>();
        Classificacao classificacao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_EQUIPE};

            c = bd.query(BancoDados.Tabela.TABELA_CLASSIFICACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while (c.moveToNext()) {
                classificacao = new Classificacao();
                classificacao.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_EQUIPE)));

                Log.d("teste", classificacao.toString());
                lista.add(classificacao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return lista;
    }
}
