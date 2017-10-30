package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Jogo;
import br.com.futeboldospais.futeboldospais.model.Resultado;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class JogoDAO {

    /**
     * @author Daniel Almeida
     * Metodo utilizado para gravar novos dados na tabela do banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @param lista ArrayList de objetos passados para carregar as informações no ContentValues
     */
    public void inserirDados(SQLiteDatabase bd, List<Jogo> lista) {

        ContentValues valores = new ContentValues();

        for (Jogo jogo : lista) {
            valores.put(BancoDados.Tabela.COLUNA_JOGO_RODADA, jogo.getRodada());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_TURNO, jogo.getTurno());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_DATA, jogo.getData());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_HORARIO, jogo.getHorario());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_EQUIPE1, jogo.getEquipe1());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_EQUIPE2, jogo.getEquipe2());
            valores.put(BancoDados.Tabela.COLUNA_JOGO_CATEGORIA, jogo.getCategoria());

            long id = bd.insert(BancoDados.Tabela.TABELA_JOGO, null, valores);
        }
    }

    /**
     * @author Daniel Almeida
     * Metodo utilizado para deletar todos os dados da tabela no banco de dados
     * @param bd Conexão de gravação passada para execução do comando SQL
     */
    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_JOGO, null, null);
    }

    /**
     * @author Daniel Almeida
     * Este metodo serve para buscar o cadastro de jogos a serem jogados no banco
     * @param context Contexto da aplicação passado para obter conexão de leitura com o banco de dados
     * @param rodada Critério de busca, rodada do campeonato que se deseja buscar
     * @param turno Critério de busca, turno referente a rodada que se deseja buscar
     * @return Retorna um vetor do tipo Jogo
     */
    public Jogo[] listarDadosPorRodadaETurno(Context context, int rodada, int turno) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        ArrayList<Jogo> retLista = new ArrayList<>();
        Jogo[] lista = null;
        Jogo jogo;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_JOGO_DATA,
                    BancoDados.Tabela.COLUNA_JOGO_HORARIO,
                    BancoDados.Tabela.COLUNA_JOGO_EQUIPE1,
                    BancoDados.Tabela.COLUNA_JOGO_EQUIPE2,
                    BancoDados.Tabela.COLUNA_JOGO_CATEGORIA};

            String where =
                    BancoDados.Tabela.COLUNA_JOGO_RODADA + " = ? AND " + BancoDados.Tabela.COLUNA_JOGO_TURNO + " = ?";

            String[] valorWhere =
                    { String.valueOf(rodada), String.valueOf(turno) };

            c = bd.query(BancoDados.Tabela.TABELA_JOGO,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            if(c.getCount() != 0) {
                while (c.moveToNext()) {
                    jogo = new Jogo();
                    jogo.setData(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_DATA)));
                    jogo.setHorario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_HORARIO)));
                    jogo.setEquipe1(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_EQUIPE1)));
                    jogo.setEquipe2(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_EQUIPE2)));
                    jogo.setCategoria(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGO_CATEGORIA)));

                    Log.d("teste", jogo.toString());
                    retLista.add(jogo);
                }
                lista = retLista.toArray(new Jogo[0]);
            }
            else{
                lista = new Jogo[0];
            }
        } catch (Exception e) {
            lista = new Jogo[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }
}
