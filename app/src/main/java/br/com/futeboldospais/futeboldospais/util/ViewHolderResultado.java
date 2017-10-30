package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by luis on 19/10/17.
 */

public class ViewHolderResultado {

    ImageView escudoCasa;
    ImageView escudoVisitante;

    TextView timeCasa;
    TextView timeVisitante;

    TextView golsCasa;
    TextView golsVisitante;

    TextView dataHora;
    TextView categoria;

    public ViewHolderResultado(ImageView escudoCasa, ImageView escudoVisitante, TextView timeCasa, TextView timeVisitante, TextView golsCasa, TextView golsVisitante, TextView dataHora, TextView categoria) {
        this.escudoCasa = escudoCasa;
        this.escudoVisitante = escudoVisitante;
        this.timeCasa = timeCasa;
        this.timeVisitante = timeVisitante;
        this.golsCasa = golsCasa;
        this.golsVisitante = golsVisitante;
        this.dataHora = dataHora;
        this.categoria = categoria;
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

    public TextView getCategoria() {
        return categoria;
    }

    public void setCategoria(TextView categoria) {
        this.categoria = categoria;
    }
}

