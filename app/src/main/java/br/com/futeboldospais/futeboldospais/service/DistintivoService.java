package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.DistintivoDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.rest.DistintivoRest;

/**
 * Created by Daniel Almeida on 22/10/2017.
 * Não é bem um service, que chama um DAO que não é bem DAO e um REST que não tem nada de REST
 */

public class DistintivoService {

    DistintivoDAO dao;
    DistintivoRest distintivoRest;
    ClassificacaoService classificacaoService;

    public void atualizarDistintivos(Context context, int campeonatoAnoServidor, int campeonatoAnoLocal, List<Classificacao> lista) throws Exception {

        String urlBase = "http://www.futeboldospais.com.br/campeonato" + campeonatoAnoServidor + "/distintivos/";
        String extensao = ".png";

        Bitmap b;

        try {
            dao = new DistintivoDAO();
            distintivoRest = new DistintivoRest();
            classificacaoService = new ClassificacaoService();

            if (lista != null) {
                if (campeonatoAnoLocal == -1) {
                    for (Classificacao classificacao : lista) {
                        b = distintivoRest.getDistintivo(context, urlBase + classificacao.getEquipe() + extensao);
                        dao.salvarImagemNoArmazenamentoInterno(b, context, classificacao.getEquipe());
                    }
                } else if (campeonatoAnoLocal != campeonatoAnoServidor) {
                    for (Classificacao classificacao : lista) {
                        b = distintivoRest.getDistintivo(context, urlBase + classificacao.getEquipe() + extensao);
                        dao.salvarImagemNoArmazenamentoInterno(b, context, classificacao.getEquipe());
                    }
                    excluirImagemNoArmazenamentoInterno(getDiretorio(), classificacaoService.listarEquipes(context));
                }
            }
        }
        catch (Exception e){
            throw new Exception();
        }

        /*try {

            dao = new DistintivoDAO();
            distintivoRest = new DistintivoRest();
            classificacaoService = new ClassificacaoService();

            if (lista != null) {
                if (campeonatoAnoLocal == -1) {
                    b = distintivoRest.getDistintivo(context, "https://torcidaredbulls.files.wordpress.com/2011/08/red-bull-brazil.gif?w=300&h=300");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(2).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.mirassolfc.com.br/assets/uploads/info_time/thumb_f7b54764ec3fd94e1dd458e7dc9c26c8.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(3).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://seeklogo.com/images/B/Botafogo_SP-logo-1142EAC238-seeklogo.com.gif");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(7).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://upload.wikimedia.org/wikipedia/pt/2/2e/ECSaoBento2014.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(4).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Escudo_Oficial_Ponte_Preta.png/393px-Escudo_Oficial_Ponte_Preta.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(5).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.dabase.com.br/wp-content/uploads/2017/02/LINENSE.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(1).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.gremionovorizontino.com.br/images/logo1.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(6).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://m.futebolinterior.com.br/Escudo/51/250x250");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(0).getEquipe());
                } else if (campeonatoAnoLocal != campeonatoAnoServidor) {

                    b = distintivoRest.getDistintivo(context, "https://torcidaredbulls.files.wordpress.com/2011/08/red-bull-brazil.gif?w=300&h=300");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(2).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.mirassolfc.com.br/assets/uploads/info_time/thumb_f7b54764ec3fd94e1dd458e7dc9c26c8.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(3).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://seeklogo.com/images/B/Botafogo_SP-logo-1142EAC238-seeklogo.com.gif");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(7).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://upload.wikimedia.org/wikipedia/pt/2/2e/ECSaoBento2014.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(4).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Escudo_Oficial_Ponte_Preta.png/393px-Escudo_Oficial_Ponte_Preta.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(5).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.dabase.com.br/wp-content/uploads/2017/02/LINENSE.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(1).getEquipe());
                    b = distintivoRest.getDistintivo(context, "http://www.gremionovorizontino.com.br/images/logo1.png");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(6).getEquipe());
                    b = distintivoRest.getDistintivo(context, "https://m.futebolinterior.com.br/Escudo/51/250x250");
                    dao.salvarImagemNoArmazenamentoInterno(b, context, lista.get(0).getEquipe());

                    excluirImagemNoArmazenamentoInterno(getDiretorio(), classificacaoService.listarEquipes(context));
                }
            }
        }
        catch (Exception e){
            throw new Exception();
        }*/
    }

    public Bitmap carregarImagemDoArmazenamentoInterno(String diretorio, String nome) throws Exception {
        dao = new DistintivoDAO();
        return dao.carregarImagemDoArmazenamentoInterno(diretorio, nome);
    }

    public boolean excluirImagemNoArmazenamentoInterno(String diretorio, List<Classificacao> lista) throws Exception {
        dao = new DistintivoDAO();
        boolean todosExcluidos = false;

        if (lista != null) {
            for (Classificacao classificacao : lista) {
                todosExcluidos = dao.excluirImagemNoArmazenamentoInterno(diretorio, classificacao.getEquipe());
            }
        }
        return todosExcluidos;
    }

    public String getDiretorio() {
        String diretorio = "/data/data/br.com.futeboldospais.futeboldospais/app_distintivos";
        return diretorio;
    }
}
