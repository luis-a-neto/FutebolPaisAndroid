<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.util;

import android.widget.TextView;

/**
 * Created by Pamela e Vinicius on 30/09/2017.
 */

public class ViewHolderArtilharia {

    TextView nome;
    TextView numero;
    TextView posicao;
    TextView equipe;

    public ViewHolderArtilharia() {
    }

    public ViewHolderArtilharia(TextView nome, TextView numero, TextView posicao, TextView equipe) {
        this.nome = nome;
        this.numero = numero;
        this.posicao = posicao;
        this.equipe = equipe;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getNumero() {
        return numero;
    }

    public void setNumero(TextView numero) {
        this.numero = numero;
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
}
=======
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
>>>>>>> repo-pamela/master
