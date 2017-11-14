package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.BancoDadosHelper;
import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.model.Atualizacao;
import br.com.futeboldospais.futeboldospais.model.Cartao;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.Configuracao;
import br.com.futeboldospais.futeboldospais.model.Jogo;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.model.Suspensao;

/**
 * Created by Daniel Almeida on 09/10/2017.
 */

public class AtualizacaoService {

    private ConfiguracaoService configuracaoService;
    private DistintivoService distintivoService;
    private ClassificacaoService classificacaoService;
    private ArtilhariaService artilhariaService;
    private CartaoService cartaoService;
    private SuspensaoService suspensaoService;
    private ResultadoService resultadoService;
    private JogoService jogoService;
    private Atualizacao atualizacao;
    private Context context;


    public AtualizacaoService(Context context) {
        atualizacao = new Atualizacao();
        this.context = context;
    }


    public int verificarAtualizacao() {
        Log.d("teste", "entrou no verificar atualização");

        int verificarAtualizacao;

        try {
            configuracaoService = new ConfiguracaoService();
            Log.d("teste", "1 - instanciou configuracao service");
            atualizacao.setConfiguracaoServidor(configuracaoService.getConfiguracaoServidor());
            Log.d("teste", atualizacao.getConfiguracaoServidor().toString());

            atualizacao.setVersaoLocal(configuracaoService.getVersaoLocal(context));
            atualizacao.setCampeonatoAnoLocal(configuracaoService.getCampeonatoAnoLocal(context));
            Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
            //atualizacao.setVersaoServidor(atualizacao.getConfiguracaoServidor().getVersao());
            Log.d("teste", "versao atual: " + atualizacao.getConfiguracaoServidor().getVersaoAtualizacao());
            Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
            //atualizacao.setCampeonatoAnoServidor(atualizacao.getConfiguracaoServidor().getCampeonatoAno());
            Log.d("teste", "campeonato ano servidor: " + atualizacao.getConfiguracaoServidor().getCampeonatoAno());
            Log.d("teste", "ultima atualizacao: " + configuracaoService.getUltimaAtualizacao(context));

            if (atualizacao.getCampeonatoAnoLocal() == -1) {
                atualizacao.setTipoAtualizacao(1);
                verificarAtualizacao = 1;
            } else if (atualizacao.getCampeonatoAnoLocal() != atualizacao.getConfiguracaoServidor().getCampeonatoAno()) {
                atualizacao.setTipoAtualizacao(2);
                verificarAtualizacao = 1;
            } else if (atualizacao.getVersaoLocal() != atualizacao.getConfiguracaoServidor().getVersaoAtualizacao()) {
                atualizacao.setTipoAtualizacao(3);
                verificarAtualizacao = 1;
            } else {
                atualizacao.setTipoAtualizacao(0);
                verificarAtualizacao = 2;
            }

            Log.d("teste", "tipo attualizacao: " + atualizacao.getTipoAtualizacao());
        } catch (Exception e) {
            verificarAtualizacao = 3;
        }

        return verificarAtualizacao;
    }

    public boolean executarAtualizacaoPorTipo() {
        Log.d("teste", "1 - entrou no executar atualizacao");

        boolean atualizacaoStatus = false;

        try {

            if (atualizacao.getTipoAtualizacao() == 1) {
                atualizacaoStatus = atualizarDados(atualizacao.getConfiguracaoServidor(), atualizacao.getCampeonatoAnoLocal(), configuracaoService);
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou primeira atualizacao");
            } else if (atualizacao.getTipoAtualizacao() == 2) {
                atualizacaoStatus = atualizarDados(atualizacao.getConfiguracaoServidor(), atualizacao.getCampeonatoAnoLocal(), configuracaoService);
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou atualizacao anual");
            } else if (atualizacao.getTipoAtualizacao() == 3) {
                atualizacaoStatus = atualizarDados(atualizacao.getConfiguracaoServidor(), atualizacao.getCampeonatoAnoLocal(), configuracaoService);
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou atualizacao semanal");
            } else {
                Log.d("teste", "nao executou atualizacao");
            }

        } catch (Exception e) {
            atualizacaoStatus = false;
        }

        return atualizacaoStatus;
    }

    public boolean atualizarDados(Configuracao configuracaoServidor, int campeonatoAnoLocal, ConfiguracaoService configuracaoService) throws Exception {
        Log.d("teste", "entrou no atualizar dados");

        boolean atualizacaoStatus = false;

        SQLiteDatabase bd = null;
        Log.d("teste", "criou sqlitehelper");

        List<Classificacao> listaClassificacao = null;
        List<Artilharia> listaArtilharia;
        List<Cartao> listaCartaoAmarelo;
        List<Cartao> listaCartaoVermelho;
        List<Suspensao> listaSuspensao;
        List<Resultado> listaResutado;
        List<Jogo> listaJogo;

        try {
            distintivoService = new DistintivoService();
            classificacaoService = new ClassificacaoService();
            artilhariaService = new ArtilhariaService();
            cartaoService = new CartaoService();
            suspensaoService = new SuspensaoService();
            resultadoService = new ResultadoService();
            jogoService = new JogoService();
            Log.d("teste", "instanciou os services");

            bd = BancoDadosHelper.FabricaDeConexao.getConexaoServico(context);
            Log.d("teste", "recebeu uma conexao de servico");

            listaClassificacao = classificacaoService.getClassificacao(configuracaoServidor.getCampeonatoAno());
            listaArtilharia = artilhariaService.getArtilharia(configuracaoServidor.getCampeonatoAno());
            listaCartaoAmarelo = cartaoService.getCartaoAmarelo(configuracaoServidor.getCampeonatoAno());
            listaCartaoVermelho = cartaoService.getCartaoVermelho(configuracaoServidor.getCampeonatoAno());
            listaSuspensao = suspensaoService.getSuspensao(configuracaoServidor.getCampeonatoAno());
            listaResutado = resultadoService.getResultado(configuracaoServidor.getCampeonatoAno());
            listaJogo = jogoService.getJogo(configuracaoServidor.getCampeonatoAno());
            Log.d("teste", "carregou as listas");

            distintivoService.atualizarDistintivos(context, configuracaoServidor.getCampeonatoAno(), campeonatoAnoLocal, listaClassificacao);

            Log.d("teste", "deu pau");

            bd.beginTransaction();
            Log.d("teste", "iniciou a transacao");

            classificacaoService.deletarDados(bd);
            artilhariaService.deletarDados(bd);
            cartaoService.deletarDados(bd);
            suspensaoService.deletarDados(bd);
            resultadoService.deletarDados(bd);
            jogoService.deletarDados(bd);
            Log.d("teste", "deletou dados antigos");
            classificacaoService.inserirDados(bd, listaClassificacao);
            artilhariaService.inserirDados(bd, listaArtilharia);
            cartaoService.inserirDados(bd, listaCartaoAmarelo, listaCartaoVermelho);
            suspensaoService.inserirDados(bd, listaSuspensao);
            resultadoService.inserirDados(bd, listaResutado);
            jogoService.inserirDados(bd, listaJogo);
            Log.d("teste", "inseriu novos dados");

            configuracaoService.atualizarVersaoLocal(bd, configuracaoServidor, campeonatoAnoLocal);
            Log.d("teste", "atualizou a versao");

            bd.setTransactionSuccessful();
            Log.d("teste", "1 - deu commit");

            atualizacaoStatus = true;

        } catch (Exception e) {
            try {
                if (campeonatoAnoLocal == -1) {
                    distintivoService.excluirImagemNoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao);
                } else if (campeonatoAnoLocal != configuracaoServidor.getCampeonatoAno()) {
                    distintivoService.excluirImagemNoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao);
                }
            } catch (Exception ex) {
                atualizacaoStatus = false;
            }
            atualizacaoStatus = false;
            Log.d("teste", " 2 - transacao falhou");
        } finally {
            if (bd != null) {
                bd.endTransaction();
                Log.d("teste", "1 - finalizou transacao com sucesso, 2 - deu rollback");
            }
        }
        return atualizacaoStatus;
    }
}
