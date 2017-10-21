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
