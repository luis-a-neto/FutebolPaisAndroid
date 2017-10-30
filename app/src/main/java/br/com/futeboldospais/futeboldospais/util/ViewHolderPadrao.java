package br.com.futeboldospais.futeboldospais.util;

import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ThirdSystem on 29/10/2017.
 */

public class ViewHolderPadrao {

    private TextView padrao;

    public ViewHolderPadrao(TextView padrao) {
        this.padrao = padrao;
    }

    public TextView getPadrao() {
        return padrao;
    }

    public void setPadrao(TextView padrao) {
        this.padrao = padrao;
    }
}
