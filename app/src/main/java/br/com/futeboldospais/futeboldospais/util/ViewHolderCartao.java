package br.com.futeboldospais.futeboldospais.util;

import android.widget.TextView;

/**
 * Created by Bruno on 18/10/2017.
 * Created by Solange on 18/10/2017.
 * Created by Graziele on 18/10/2017.
 * Created by Tamires on 18/10/2017.
 */

public class ViewHolderCartao {

    private TextView jogador;
    private TextView equipe;
    //Cartão que o jogador tomou em campo
    private TextView cartaoJogo;
    private TextView data;
    private TextView juiz;
    private TextView adversario;
    private TextView tempo;

    public ViewHolderCartao(TextView jogador, TextView equipe, TextView cartaoJogo, TextView data, TextView juiz, TextView adversario, TextView tempo) {
        this.jogador = jogador;
        this.equipe = equipe;
        this.cartaoJogo = cartaoJogo;
        this.data = data;
        this.juiz = juiz;
        this.adversario = adversario;
        this.tempo = tempo;
    }

    public TextView getJogador() {
        return jogador;
    }

    public void setJogador(TextView jogador) {
        this.jogador = jogador;
    }

    public TextView getEquipe() {
        return equipe;
    }

    public void setEquipe(TextView equipe) {
        this.equipe = equipe;
    }

    public TextView getCartaoJogo() {
        return cartaoJogo;
    }

    public void setCartaoJogo(TextView cartaoJogo) {
        this.cartaoJogo = cartaoJogo;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getJuiz() {
        return juiz;
    }

    public void setJuiz(TextView juiz) {
        this.juiz = juiz;
    }

    public TextView getAdversario() {
        return adversario;
    }

    public void setAdversario(TextView adversario) {
        this.adversario = adversario;
    }

    public TextView getTempo() {
        return tempo;
    }

    public void setTempo(TextView tempo) {
        this.tempo = tempo;
    }
}
