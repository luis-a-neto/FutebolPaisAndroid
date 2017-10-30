package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pamela e Vinicius on 30/09/2017.
 */

public class ViewHolderArtilharia {

    TextView top;
    ImageView equipe;
    TextView jogador;
    TextView posicao;
    TextView gols;

    public ViewHolderArtilharia(TextView top, ImageView equipe, TextView jogador, TextView posicao, TextView gols) {
        this.top = top;
        this.equipe = equipe;
        this.jogador = jogador;
        this.posicao = posicao;
        this.gols = gols;
    }

    public TextView getTop() {
        return top;
    }

    public void setTop(TextView top) {
        this.top = top;
    }

    public ImageView getEquipe() {
        return equipe;
    }

    public void setEquipe(ImageView equipe) {
        this.equipe = equipe;
    }

    public TextView getJogador() {
        return jogador;
    }

    public void setJogador(TextView jogador) {
        this.jogador = jogador;
    }

    public TextView getPosicao() {
        return posicao;
    }

    public void setPosicao(TextView posicao) {
        this.posicao = posicao;
    }

    public TextView getGols() {
        return gols;
    }

    public void setGols(TextView gols) {
        this.gols = gols;
    }
}
