package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadasHelper {

    private Fragment fragmentoSelecionado;
    private String rodada;


    public Fragment getFragmentoSelecionado() {
        return fragmentoSelecionado;
    }

    public void setFragmentoSelecionado(Fragment fragmentoSelecionado) {
        this.fragmentoSelecionado = fragmentoSelecionado;
    }

    public String getRodada() {
        return rodada;
    }

    public void setRodada(String rodada) {
        this.rodada = rodada;
    }
}
