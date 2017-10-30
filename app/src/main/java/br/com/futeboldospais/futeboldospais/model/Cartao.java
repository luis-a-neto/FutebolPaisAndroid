package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe de negócio padrão
 */

public class Cartao implements Serializable{

    private String equipe;
    private int numero;
    private String jogador;
    private String data;
    private String tempo;
    private String adversario;
    private String arbitro;

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getAdversario() {
        return adversario;
    }

    public void setAdversario(String adversario) {
        this.adversario = adversario;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "equipe='" + equipe + '\'' +
                ", numero=" + numero +
                ", jogador='" + jogador + '\'' +
                ", data='" + data + '\'' +
                ", tempo='" + tempo + '\'' +
                ", adversario='" + adversario + '\'' +
                ", arbitro='" + arbitro + '\'' +
                '}';
    }
}
