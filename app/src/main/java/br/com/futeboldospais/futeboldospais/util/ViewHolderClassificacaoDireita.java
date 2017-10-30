package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ThirdSystem on 24/10/2017.
 */

public class ViewHolderClassificacaoDireita {

    private TextView pontosGanhos;
    private TextView jogos;
    private TextView vitorias;
    private TextView empates;
    private TextView derrotas;
    private TextView golsPro;
    private TextView golsContra;
    private TextView saldoGols;
    private TextView cartoesAmarelos;
    private TextView cartoesVemelhos;
    private TextView pontosDisciplinares;

    public ViewHolderClassificacaoDireita(TextView pontosGanhos, TextView jogos, TextView vitorias, TextView empates, TextView derrotas, TextView golsPro, TextView golsContra, TextView saldoGols, TextView cartoesAmarelos, TextView cartoesVemelhos, TextView pontosDisciplinares) {
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsPro = golsPro;
        this.golsContra = golsContra;
        this.saldoGols = saldoGols;
        this.cartoesAmarelos = cartoesAmarelos;
        this.cartoesVemelhos = cartoesVemelhos;
        this.pontosDisciplinares = pontosDisciplinares;
    }

    public TextView getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(TextView pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public TextView getJogos() {
        return jogos;
    }

    public void setJogos(TextView jogos) {
        this.jogos = jogos;
    }

    public TextView getVitorias() {
        return vitorias;
    }

    public void setVitorias(TextView vitorias) {
        this.vitorias = vitorias;
    }

    public TextView getEmpates() {
        return empates;
    }

    public void setEmpates(TextView empates) {
        this.empates = empates;
    }

    public TextView getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(TextView derrotas) {
        this.derrotas = derrotas;
    }

    public TextView getGolsPro() {
        return golsPro;
    }

    public void setGolsPro(TextView golsPro) {
        this.golsPro = golsPro;
    }

    public TextView getGolsContra() {
        return golsContra;
    }

    public void setGolsContra(TextView golsContra) {
        this.golsContra = golsContra;
    }

    public TextView getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(TextView saldoGols) {
        this.saldoGols = saldoGols;
    }

    public TextView getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public void setCartoesAmarelos(TextView cartoesAmarelos) {
        this.cartoesAmarelos = cartoesAmarelos;
    }

    public TextView getCartoesVemelhos() {
        return cartoesVemelhos;
    }

    public void setCartoesVemelhos(TextView cartoesVemelhos) {
        this.cartoesVemelhos = cartoesVemelhos;
    }

    public TextView getPontosDisciplinares() {
        return pontosDisciplinares;
    }

    public void setPontosDisciplinares(TextView pontosDisciplinares) {
        this.pontosDisciplinares = pontosDisciplinares;
    }
}
