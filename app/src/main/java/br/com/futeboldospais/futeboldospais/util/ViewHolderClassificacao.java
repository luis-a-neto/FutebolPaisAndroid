package br.com.futeboldospais.futeboldospais.util;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by Administrador on 29/09/2017.
 */

public class ViewHolderClassificacao {

    private TextView posicao;
    private TextView equipe;
    private TextView pontosGanhos;
    private TextView jogos;
    private TextView vitorias;
    private TextView saldoGols;

    public ViewHolderClassificacao(){
        //Construtor padrão
    }

    public ViewHolderClassificacao(TextView posicao, TextView equipe, TextView pontosGanhos, TextView jogos, TextView vitorias, TextView saldoGols) {
        this.posicao = posicao;
        this.equipe = equipe;
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.saldoGols = saldoGols;
    }

    public TextView getPosicao() {
        return posicao;
    }

    public void setPosicao(TextView posicao) {
        this.posicao = posicao;
    }

    public TextView getEquipe() {
        return equipe;
    }

    public void setEquipe(TextView equipe) {
        this.equipe = equipe;
    }

    public TextView getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(TextView pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public TextView getJogos() {
        return jogos;
    }

    public void setJogos(TextView jogos) {
        this.jogos = jogos;
    }

    public TextView getVitorias() {
        return vitorias;
    }

    public void setVitorias(TextView vitorias) {
        this.vitorias = vitorias;
    }

    public TextView getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(TextView saldoGols) {
        this.saldoGols = saldoGols;
    }
}
