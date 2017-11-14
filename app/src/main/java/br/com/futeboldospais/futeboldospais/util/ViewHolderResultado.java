package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
<<<<<<< HEAD
    Projeto:    FutebolPaisAndroid
    Arquivo:    ViewHolderResultado.java
    Autor:      Luis Andrade
    Data:       24.09.2017

    Classe ViewHolder de resultados. Temos oito elementos para cada resultado listado.

    Histórico de modificações:
    Data ______ Autor _________________ Resumo ___________________________________________________
    24.09.2017  Luis Andrade            Inicial
    29.09.2017  Daniel Almeida          Adequação
**/
=======
 * Created by luis on 19/10/17.
 */
>>>>>>> repo-pamela/master

public class ViewHolderResultado {

    ImageView escudoCasa;
    ImageView escudoVisitante;

    TextView timeCasa;
    TextView timeVisitante;

    TextView golsCasa;
    TextView golsVisitante;

    TextView dataHora;
<<<<<<< HEAD
    TextView estadio;

    public ViewHolderResultado(ImageView escudoCasa, ImageView escudoVisitante, TextView timeCasa, TextView timeVisitante, TextView golsCasa, TextView golsVisitante, TextView dataHora, TextView estadio) {
=======
    TextView categoria;

    public ViewHolderResultado(ImageView escudoCasa, ImageView escudoVisitante, TextView timeCasa, TextView timeVisitante, TextView golsCasa, TextView golsVisitante, TextView dataHora, TextView categoria) {
>>>>>>> repo-pamela/master
        this.escudoCasa = escudoCasa;
        this.escudoVisitante = escudoVisitante;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.golsCasa = golsCasa;
        this.golsVisitante = golsVisitante;
        this.dataHora = dataHora;
<<<<<<< HEAD
        this.estadio = estadio;
=======
        this.categoria = categoria;
>>>>>>> repo-pamela/master
    }

    public ImageView getEscudoCasa() {
        return escudoCasa;
    }

    public void setEscudoCasa(ImageView escudoCasa) {
        this.escudoCasa = escudoCasa;
    }

    public ImageView getEscudoVisitante() {
        return escudoVisitante;
    }

    public void setEscudoVisitante(ImageView escudoVisitante) {
        this.escudoVisitante = escudoVisitante;
    }

    public TextView getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(TextView timeCasa) {
        this.timeCasa = timeCasa;
    }

    public TextView getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(TextView timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public TextView getGolsCasa() {
        return golsCasa;
    }

    public void setGolsCasa(TextView golsCasa) {
        this.golsCasa = golsCasa;
    }

    public TextView getGolsVisitante() {
        return golsVisitante;
    }

    public void setGolsVisitante(TextView golsVisitante) {
        this.golsVisitante = golsVisitante;
    }

    public TextView getDataHora() {
        return dataHora;
    }

    public void setDataHora(TextView dataHora) {
        this.dataHora = dataHora;
    }

<<<<<<< HEAD
    public TextView getEstadio() {
        return estadio;
    }

    public void setEstadio(TextView estadio) {
        this.estadio = estadio;
=======
    public TextView getCategoria() {
        return categoria;
    }

    public void setCategoria(TextView categoria) {
        this.categoria = categoria;
>>>>>>> repo-pamela/master
    }
}

