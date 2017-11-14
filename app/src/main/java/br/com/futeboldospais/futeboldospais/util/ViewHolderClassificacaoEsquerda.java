package br.com.futeboldospais.futeboldospais.util;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrador on 29/09/2017.
 */

public class ViewHolderClassificacaoEsquerda {

    private TextView posicao;
    private ImageView escudo;
    private TextView equipe;

    public ViewHolderClassificacaoEsquerda(TextView posicao, ImageView escudo, TextView equipe) {
        this.posicao = posicao;
        this.escudo = escudo;
        this.equipe = equipe;
    }

    public TextView getPosicao() {
        return posicao;
    }

    public void setPosicao(TextView posicao) {
        this.posicao = posicao;
    }

    public ImageView getEscudo() {
        return escudo;
    }

    public void setEscudo(ImageView escudo) {
        this.escudo = escudo;
    }

    public TextView getEquipe() {
        return equipe;
    }

    public void setEquipe(TextView equipe) {
        this.equipe = equipe;
    }
}
