package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Configuracao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Daniel Almeida on 12/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class ConfiguracaoDAO {

    /**
     * @param bd                   Conexão de gravação passada para execução do comando SQL
     * @param configuracaoServidor Configuração obtida do servidor na internet
     * @param campeonatoAnoLocal   Ano do campeonato atual no banco de dados dos dados da aplicação
     * @author Daniel Almeida
     * Este método serve para inserir uma nova versão de controle ou atualizar o controle de vesão dos dados da aplicação,
     * caso a atualização do conteúdo do banco dados tenha sido realizado com sucesso
     */
    public void atualizarVersaoLocal(SQLiteDatabase bd, Configuracao configuracaoServidor, int campeonatoAnoLocal) {

        Date dataHora = new Date();
        ContentValues valores = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Log.d("teste", "versao passada: " + campeonatoAnoLocal);
        if (campeonatoAnoLocal == -1) {
            Log.d("teste", "entrou no if");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_HOMENAGEADO, configuracaoServidor.getHomenageado());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO_ATUALIZACAO, configuracaoServidor.getVersaoAtualizacao());

            bd.insert(BancoDados.Tabela.TABELA_CONFIGURACAO, null, valores);
            Log.d("teste", "inseriu a versao");
        } else {
            Log.d("teste", "entrou no else");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_HOMENAGEADO, configuracaoServidor.getHomenageado());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO_ATUALIZACAO, configuracaoServidor.getVersaoAtualizacao());
            Log.d("teste", "inseriu os valores");
            int count = bd.update(
                    BancoDados.Tabela.TABELA_CONFIGURACAO,
                    valores,
                    null,
                    null
            );
        }
    }

    public Configuracao listarDados(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Configuracao configuracao;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {
                    BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO,
                    BancoDados.Tabela.COLUNA_CONFIGURACAO_HOMENAGEADO,
                    BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                configuracao = new Configuracao();

                configuracao.setCampeonatoAno(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO)));
                configuracao.setHomenageado(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_HOMENAGEADO)));
                configuracao.setTema(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA)));

                Log.d("teste", configuracao.toString());
            } else {
                configuracao = new Configuracao();
            }
        } catch (Exception e) {
            return new Configuracao();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return configuracao;
    }

    /**
     * @param context Contexto da aplicação utilzado para obter conexão de leitura com o banco de dados
     * @return Versão atual no banco de dados dos dados da aplicação
     * @author Daniel Almeida
     */
    public int getVersaoLocal(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        int versao = -1;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO_ATUALIZACAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                versao = c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO_ATUALIZACAO));
            } else {
                versao = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return versao;
    }

    public int getCampeonatoAnoLocal(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        int campeonatoAno = -1;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                campeonatoAno = c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO_ANO));
            } else {
                campeonatoAno = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return campeonatoAno;
    }

    /**
     * @param context Contexto da aplicação utilzado para obter conexão de leitura com o banco de dados
     * @return Hora e data da ultima atualização dos dados da aplicação
     * @author Daniel Almeida
     */
    public String getUltimaAtualizacao(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        String dataHora = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                dataHora = c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO));
            } else {
                dataHora = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return dataHora;
    }
}
