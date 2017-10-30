package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daniel Almeida on 09/10/2017.
 * Classe de configuração
 */

public class Configuracao implements Serializable{

    private int campeonatoAno;
    private String homenageado;
    private String tema;
    private int versaoAtualizacao;

    public int getCampeonatoAno() {
        return campeonatoAno;
    }

    public void setCampeonatoAno(int campeonatoAno) {
        this.campeonatoAno = campeonatoAno;
    }

    public String getHomenageado() {
        return homenageado;
    }

    public void setHomenageado(String homenageado) {
        this.homenageado = homenageado;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getVersaoAtualizacao() {
        return versaoAtualizacao;
    }

    public void setVersaoAtualizacao(int versaoAtualizacao) {
        this.versaoAtualizacao = versaoAtualizacao;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "campeonatoAno=" + campeonatoAno +
                ", homenageado='" + homenageado + '\'' +
                ", tema='" + tema + '\'' +
                ", versaoAtualizacao=" + versaoAtualizacao +
                '}';
    }
}
