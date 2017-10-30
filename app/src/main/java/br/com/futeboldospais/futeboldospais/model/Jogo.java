package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by Luis Andrade on 17/10/2017.
 */

public class Jogo implements Serializable{

    private int rodada;
    private int turno;
    private String data;
    private String horario;
    private String equipe1;
    private String equipe2;
    private String categoria;

    public int getRodada() {
        return rodada;
    }

    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(String equipe1) {
        this.equipe1 = equipe1;
    }

    public String getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(String equipe2) {
        this.equipe2 = equipe2;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "rodada=" + rodada +
                ", turno=" + turno +
                ", data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", equipe1='" + equipe1 + '\'' +
                ", equipe2='" + equipe2 + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
