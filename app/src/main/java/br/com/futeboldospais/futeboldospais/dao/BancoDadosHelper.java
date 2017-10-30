package br.com.futeboldospais.futeboldospais.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Daniel Almeida on 05/10/2017.
 * Esta classe serve para criar o banco de dados SQLite da aplicação e criar
 * conexão com este a partir de sua instanciação
 */

public class BancoDadosHelper extends SQLiteOpenHelper{

    /**
     * Construtor utilizado para criação e acesso ao banco de dados
     * @param context Contexto da aplicação onde será criado o banco
     */
    private BancoDadosHelper(Context context){
        super(context, BancoDados.BANCO_NOME, null, BancoDados.BANCO_VERSAO);
        Log.d("teste", "6 - entrou no construtor da banco dados helper");
    }

    /**
     * Este método cria todas as tabelas do bando de dados da aplicação
     * Ele é executado apenas na primeira vez que a classe é instanciada
     * @param bd Conexão passada para execução dos comandos SQL de criação de tabelas
     */
    public void onCreate(SQLiteDatabase bd){
        bd.execSQL(BancoDados.CRIAR_TABELA_CONFIGURACAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_CLASSIFICACAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_ARTILHARIA);
        bd.execSQL(BancoDados.CRIAR_TABELA_CARTAO_AMARELO);
        bd.execSQL(BancoDados.CRIAR_TABELA_CARTAO_VERMELHO);
        bd.execSQL(BancoDados.CRIAR_TABELA_SUSPENSAO);
        bd.execSQL(BancoDados.CRIAR_TABELA_RESULTADO);
        bd.execSQL(BancoDados.CRIAR_TABELA_JOGO);
        Log.d("teste", "Teste 1 - criou as tabelas");
    }

    /**
     * Este método serve para realizar updrade na versão do banco de dados da aplicação
     * Ele deleta as tabelas e cria novas tabelas
     * @param bd Conexão passada para execução dos comando SQL para dropar as tabelas
     * @param versaoAntiga Versão atual do banco de dados aplicação
     * @param novaVersao Nova versão que será utilizada pelo banco de dados da aplicação
     */
    public void onUpgrade(SQLiteDatabase bd, int versaoAntiga, int novaVersao){
        bd.execSQL(BancoDados.DELETAR_TABELA_CONFIGURACAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_CLASSIFICACAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_ARTILHARIA);
        bd.execSQL(BancoDados.DELETAR_TABELA_AMARELO);
        bd.execSQL(BancoDados.DELETAR_TABELA_VERMELHO);
        bd.execSQL(BancoDados.DELETAR_TABELA_SUSPENSAO);
        bd.execSQL(BancoDados.DELETAR_TABELA_RESULTADO);
        bd.execSQL(BancoDados.DELETAR_TABELA_JOGO);
        onCreate(bd);
    }

    /**
     * Classe interna para fornecer conexão ao banco de dados da aplicação
     */
    public static class FabricaDeConexao {

        private static SQLiteDatabase CONEXAO_APLICACAO = null;
        private static SQLiteDatabase CONEXAO_SERVICO = null;

        private static BancoDadosHelper BANCO_DADOS_HELPER;

        /**
         * @author Daniel Almeida
         * Este método serve para fornecer uma conexão única de leitura a ser utlizada
         * pela aplicação
         */
        private FabricaDeConexao(){}

        public static SQLiteDatabase getConexaoAplicacao(Context context){

            if(CONEXAO_APLICACAO == null){
                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                CONEXAO_APLICACAO = BANCO_DADOS_HELPER.getReadableDatabase();
            }
            return CONEXAO_APLICACAO;
        }

        /**
         * @author Daniel Almeida
         * Este método serve para fornecer uma conexão única de gravação no banco a ser utlizada
         * pelo serviço android
         */
        public static SQLiteDatabase getConexaoServico(Context context){
            Log.d("teste", "4 - entrou no get conexao servico");

            if(CONEXAO_SERVICO == null){
                Log.d("teste", "5 - verificou a conexao servico");

                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                Log.d("teste", "7 - instanciou banco dados helper");

                CONEXAO_SERVICO = BANCO_DADOS_HELPER.getWritableDatabase();
                Log.d("teste", "8 - inseriu a conexao");
            }
            return CONEXAO_SERVICO;
        }

        /**
         * @author Daniel Almeida
         * Este método deverá ser chamado para criar a primeira instância da classe SQLiteOpenHelper
         * e assim criar o banco de dados e as tabelas
         */
        public static void criarBancoDados(Context context){
            getConexaoAplicacao(context);
        }

        /**
         * @author Daniel Almeida
         * Este método serve para encerrar a conexão de leitura se estiver aberta
         */
        public static void fecharConexaoAplicacao(){
            if(CONEXAO_APLICACAO != null) {
                CONEXAO_APLICACAO.close();
            }
        }

        /**
         * @author Daniel Almeida
         * Este método serve para encerrar a conexão de gravação se estiver aberta
         */
        public static void fecharConexaoServico(){
            if(CONEXAO_SERVICO != null) {
                CONEXAO_SERVICO.close();
            }
        }
    }

}
