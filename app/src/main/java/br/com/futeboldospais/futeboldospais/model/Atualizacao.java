package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;

/**
 * Created by ThirdSystem on 26/10/2017.
 */

public class Atualizacao implements Serializable{

    public static final int RESULT_CODE = 1;
    public static final String STATUS_CONEXAO = "statusConexao";
    public static final String VERIFICAR_ATUALIZACAO = "verificarAtualizacao";
    public static final String  STATUS_ATUALIZACAO = "statusAtualizacao";
    public static final String RECEPTOR = "receptor";

    private int tipoAtualizacao;
    private int versaoLocal;
    private int campeonatoAnoLocal;
    private Configuracao configuracaoServidor;

    public int getTipoAtualizacao() {
        return tipoAtualizacao;
    }

    public void setTipoAtualizacao(int tipoAtualizacao) {
        this.tipoAtualizacao = tipoAtualizacao;
    }

    public int getVersaoLocal() {
        return versaoLocal;
    }

    public void setVersaoLocal(int versaoLocal) {
        this.versaoLocal = versaoLocal;
    }

    public int getCampeonatoAnoLocal() {
        return campeonatoAnoLocal;
    }

    public void setCampeonatoAnoLocal(int campeonatoAnoLocal) {
        this.campeonatoAnoLocal = campeonatoAnoLocal;
    }

    public Configuracao getConfiguracaoServidor() {
        return configuracaoServidor;
    }

    public void setConfiguracaoServidor(Configuracao configuracaoServidor) {
        this.configuracaoServidor = configuracaoServidor;
    }
}
