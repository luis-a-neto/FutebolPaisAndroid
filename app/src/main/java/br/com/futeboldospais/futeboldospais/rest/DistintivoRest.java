package br.com.futeboldospais.futeboldospais.rest;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.Glide;

import java.util.concurrent.ExecutionException;

/**
 * Created by Daniel Almeida on 22/10/2017.
 * Classe que prove os emblemas das equipes
 * Tem nada a ver com REST, só coloquei esse nome pra ficar parecida com as outras
 */

public class DistintivoRest {

    /**
     * Método utilizado para fazer download das imagens dos logos dos time
     * utilizando a biblioteca Glide
     * @param context Contexto da aplicação
     * @param url Endereço de onde se quer fazer download da imagem
     * @return Uma imagem no formato bitmap
     */
    public static Bitmap getDistintivo(Context context, String url) throws Exception{
        Bitmap b = null;
        try {
            b = Glide.
                    with(context).
                    load(url).
                    asBitmap().
                    into(-1, -1).
                    get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return b;
    }
}
