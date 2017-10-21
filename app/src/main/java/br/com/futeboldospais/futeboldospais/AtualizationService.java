package br.com.futeboldospais.futeboldospais;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ThirdSystem on 12/10/2017.
 */

public class AtualizationService extends IntentService{

    Atualizacao atualizacao;

    public AtualizationService(){
        super("AtualizationServicePlus");
        Log.d("teste", "1 - fui iniciado");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public AtualizationService(String name) {
        super(name);
        Log.d("teste", "1 - fui iniciado");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("teste", "1 - fui iniciado aqui");

        boolean atualizacaoStatus;

        atualizacao = new Atualizacao(getBaseContext());
        Log.d("teste", "1 - instanciou atualizacao");

        atualizacaoStatus = atualizacao.verificarAtualizacao();

        stopSelf();
        Log.d("teste", "serviço auto destruido");
    }
}
