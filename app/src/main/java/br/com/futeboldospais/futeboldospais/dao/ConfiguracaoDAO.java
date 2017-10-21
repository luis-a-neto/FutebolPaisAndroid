package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Configuracao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel Almeida on 12/10/2017.
 * Classe DAO padrão utilizada para realizar crud no banco de dados SQLite da aplicação
 */

public class ConfiguracaoDAO {

    /**
     * @author Daniel Almeida
     * Este método serve para inserir uma nova versão de controle ou atualizar o controle de vesão dos dados da aplicação,
     * caso a atualização do conteúdo do banco dados tenha sido realizado com sucesso
     * @param bd Conexão de gravação passada para execução do comando SQL
     * @param configuracaoServidor Configuração obtida do servidor na internet
     * @param versaoLocal Versão atual no banco de dados dos dados da aplicação
     */
    public void atualizarVersaoLocal(SQLiteDatabase bd, Configuracao configuracaoServidor, int versaoLocal) {

        Date dataHora = new Date();
        ContentValues valores = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Log.d("teste", "versao passada: " + versaoLocal);
        if(versaoLocal == -1){
            Log.d("teste", "entrou no if");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO, configuracaoServidor.getVersao());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());

            bd.insert(BancoDados.Tabela.TABELA_CONFIGURACAO, null, valores);
            Log.d("teste", "inseriu a versao");
        }
        else {
            Log.d("teste", "entrou no else");
            Log.d("teste", dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO, dateFormat.format(dataHora));
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_CAMPEONATO, configuracaoServidor.getCampeonatoAno());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO, configuracaoServidor.getVersao());
            valores.put(BancoDados.Tabela.COLUNA_CONFIGURACAO_TEMA, configuracaoServidor.getTema());
            Log.d("teste", "inseriu os valores");
            int count = bd.update(
                    BancoDados.Tabela.TABELA_CONFIGURACAO,
                    valores,
                    null,
                    null
            );
        }
    }

    /**
     * @author Daniel Almeida
     * @param context Contexto da aplicação utilzado para obter conexão de leitura com o banco de dados
     * @return Versão atual no banco de dados dos dados da aplicação
     */
    public int getVersaoLocal(Context context){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        int versao = -1;

        try{

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.moveToFirst()){
                versao = c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_VERSAO));
            }
            else{
                versao = -1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(c != null) {
                c.close();
            }
        }

        return versao;
    }

    /**
     * @author Daniel Almeida
     * @param context Contexto da aplicação utilzado para obter conexão de leitura com o banco de dados
     * @return Hora e data da ultima atualização dos dados da aplicação
     */
    public String getUltimaAtualizacao(Context context){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        String dataHora = null;

        try{

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO};

            c = bd.query(BancoDados.Tabela.TABELA_CONFIGURACAO,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if(c.moveToFirst()){
                dataHora = c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CONFIGURACAO_ULTIMA_ATUALIZACAO));
            }
            else{
                dataHora = null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(c != null) {
                c.close();
            }
        }

        return dataHora;
    }
}
