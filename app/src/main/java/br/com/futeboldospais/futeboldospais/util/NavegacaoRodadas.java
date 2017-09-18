package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

import br.com.futeboldospais.futeboldospais.views.PrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.views.SegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.views.TerceiraRodadaFragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadas {

    public static int PROXIMO = 1;
    public static int ANTERIOR = 0;

    private static NavegacaoRodadasHelper navegacaoRodadasHelper = new NavegacaoRodadasHelper();

    public NavegacaoRodadas(){
        //Construtor padrão
    }

    /**
     * Created by Daniel Almeida on 15/09/2017.
     * Recebe uma direção, verifica qual a rodada atual e instacia a proxima rodada
     * de acordo com a direção recebida
     * @param direcao
     * @param fragment
     * @return uma instancia da classe NavegacaoRodadasHelper
     */
    public static NavegacaoRodadasHelper selecionaRodada(int direcao, Fragment fragment){

        if(direcao == 1){
            if(fragment.equals(PrimeiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º Turno - 2º Rodada");
            }
            else if(fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º Turno - 3º Rodada");
            }
        }
        else if(direcao == 0){
            if(fragment.equals(TerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º Turno - 2º Rodada");
            }
            else if (fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º Turno - 1º Rodada");
            }
        }

        return navegacaoRodadasHelper;
    }
}
