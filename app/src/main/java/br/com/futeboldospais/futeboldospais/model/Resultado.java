package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by Daniel Almeida on 17/10/2017.
 */

public class Resultado implements Serializable{

    private String data;
    private String horario;
    private String equipe1;
    private int golsEquipe1;
    private String equipe2;
    private int golsEquipe2;
    private int cartoesAmarelos;
    private int cartoesVermelhos;
    private int totalCartoes;
    private String categoria;
    private String arbitro;
    private String assistente1;
    private String assistente2;
    private int notaArbitroMedia;
    private int notaArbitroEquipe1;
    private int notaArbitroEquipe2;
    private int rodada;
    private int turno;

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

    public int getGolsEquipe1() {
        return golsEquipe1;
    }

    public void setGolsEquipe1(int golsEquipe1) {
        this.golsEquipe1 = golsEquipe1;
    }

    public String getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(String equipe2) {
        this.equipe2 = equipe2;
    }

    public int getGolsEquipe2() {
        return golsEquipe2;
    }

    public void setGolsEquipe2(int golsEquipe2) {
        this.golsEquipe2 = golsEquipe2;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public void setCartoesAmarelos(int cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public void setCartoesVermelhos(int cartoesVermelhos) {
        this.cartoesVermelhos = cartoesVermelhos;
    }

    public int getTotalCartoes() {
        return totalCartoes;
    }

    public void setTotalCartoes(int totalCartoes) {
        this.totalCartoes = totalCartoes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getAssistente1() {
        return assistente1;
    }

    public void setAssistente1(String assistente1) {
        this.assistente1 = assistente1;
    }

    public String getAssistente2() {
        return assistente2;
    }

    public void setAssistente2(String assistente2) {
        this.assistente2 = assistente2;
    }

    public int getNotaArbitroMedia() {
        return notaArbitroMedia;
    }

    public void setNotaArbitroMedia(int notaArbitroMedia) {
        this.notaArbitroMedia = notaArbitroMedia;
    }

    public int getNotaArbitroEquipe1() {
        return notaArbitroEquipe1;
    }

    public void setNotaArbitroEquipe1(int notaArbitroEquipe1) {
        this.notaArbitroEquipe1 = notaArbitroEquipe1;
    }

    public int getNotaArbitroEquipe2() {
        return notaArbitroEquipe2;
    }

    public void setNotaArbitroEquipe2(int notaArbitroEquipe2) {
        this.notaArbitroEquipe2 = notaArbitroEquipe2;
    }

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

    @Override
    public String toString() {
        return "Resultado{" +
                "data='" + data + '\'' +
                ", horario='" + horario + '\'' +
                ", equipe1='" + equipe1 + '\'' +
                ", golsEquipe1=" + golsEquipe1 +
                ", equipe2='" + equipe2 + '\'' +
                ", golsEquipe2=" + golsEquipe2 +
                ", cartoesAmarelos=" + cartoesAmarelos +
                ", cartoesVermelhos=" + cartoesVermelhos +
                ", totalCartoes=" + totalCartoes +
                ", categoria='" + categoria + '\'' +
                ", arbitro='" + arbitro + '\'' +
                ", assistente1='" + assistente1 + '\'' +
                ", assistente2='" + assistente2 + '\'' +
                ", notaArbitroMedia=" + notaArbitroMedia +
                ", notaArbitroEquipe1=" + notaArbitroEquipe1 +
                ", notaArbitroEquipe2=" + notaArbitroEquipe2 +
                ", rodada=" + rodada +
                ", turno=" + turno +
                '}';
    }
}
