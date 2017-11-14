<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe de negócio padrão
 */

public class Suspensao implements Serializable{

    private String equipe;
    private String jogador;
    private int numero;
    private String categora;
    private int criterio;
    private String jogos;
    private String motivo;

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCategora() {
        return categora;
    }

    public void setCategora(String categora) {
        this.categora = categora;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Suspensao{" +
                "equipe='" + equipe + '\'' +
                ", jogador='" + jogador + '\'' +
                ", numero=" + numero +
                ", categora='" + categora + '\'' +
                ", criterio=" + criterio +
                ", jogos='" + jogos + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
=======
package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by Daniel Almeida on 13/10/2017.
 * Classe de negócio padrão
 */

public class Suspensao implements Serializable{

    private String equipe;
    private String jogador;
    private int numero;
    private String categoria;
    private int criterio;
    private String jogos;
    private String motivo;

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        this.criterio = criterio;
    }

    public String getJogos() {
        return jogos;
    }

    public void setJogos(String jogos) {
        this.jogos = jogos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Suspensao{" +
                "equipe='" + equipe + '\'' +
                ", jogador='" + jogador + '\'' +
                ", numero=" + numero +
                ", categoria='" + categoria + '\'' +
                ", criterio=" + criterio +
                ", jogos='" + jogos + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
>>>>>>> repo-pamela/master
