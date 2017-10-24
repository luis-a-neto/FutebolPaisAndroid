package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daniel Almeida on 09/10/2017.
 * Classe de configuração
 */

public class Configuracao implements Serializable{

    private int campeonatoAno;
    private int versao;

    public int getCampeonatoAno() {
        return campeonatoAno;
    }

    public void setCampeonatoAno(int campeonatoAno) {
        this.campeonatoAno = campeonatoAno;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    @Override
    public String toString() {
        return "Configuracao{" +
                "campeonatoAno=" + campeonatoAno +
                ", versao=" + versao +
                '}';
    }
}
