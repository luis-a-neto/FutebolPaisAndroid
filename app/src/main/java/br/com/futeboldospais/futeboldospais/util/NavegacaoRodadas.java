<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

import br.com.futeboldospais.futeboldospais.controller.PrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.TerceiraRodadaFragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadas {

    public static int PROXIMO = 1;
    public static int ANTERIOR = 0;

    private static NavegacaoRodadasHelper navegacaoRodadasHelper = new NavegacaoRodadasHelper();

    public NavegacaoRodadas(){
        //Construtor padrão
    }

    /**
     * Created by Daniel Almeida on 15/09/2017.
     * Recebe uma direção, verifica qual a rodada atual e instacia a proxima rodada
     * de acordo com a direção recebida
     * @param direcao
     * @param fragment
     * @return uma instancia da classe NavegacaoRodadasHelper
     */
    public static NavegacaoRodadasHelper selecionaRodada(int direcao, Fragment fragment){

        if(direcao == 1){
            if(fragment.equals(PrimeiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º Turno - 2º Rodada");
            }
            else if(fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º Turno - 3º Rodada");
            }
        }
        else if(direcao == 0){
            if(fragment.equals(TerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º Turno - 2º Rodada");
            }
            else if (fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º Turno - 1º Rodada");
            }
        }

        return navegacaoRodadasHelper;
    }
}
=======
package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

import br.com.futeboldospais.futeboldospais.controller.DecimaPrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaTerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.NonaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.OitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.PrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.TerceiraRodadaFragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadas {

    public static int PROXIMO = 1;
    public static int ANTERIOR = 0;

    private static NavegacaoRodadasHelper navegacaoRodadasHelper = new NavegacaoRodadasHelper();

    public NavegacaoRodadas(){
        //Construtor padrão
    }

    /**
     * Created by Daniel Almeida on 15/09/2017.
     * Recebe uma direção, verifica qual a rodada atual e instacia a proxima rodada
     * de acordo com a direção recebida
     * @param direcao
     * @param fragment
     * @return uma instancia da classe NavegacaoRodadasHelper
     */
    public static NavegacaoRodadasHelper selecionaRodada(int direcao, Fragment fragment){

        if(direcao == 1){
            if(fragment.equals(PrimeiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 2º RODADA");
            }
            else if(fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 3º RODADA");
            }
            else if(fragment.equals(TerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 4º RODADA");
            }
            else if(fragment.equals(QuartaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 5º RODADA");
            }
            else if(fragment.equals(QuintaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 6º RODADA");
            }
            else if(fragment.equals(SextaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 7º RODADA");
            }
            else if(fragment.equals(SetimaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 8º RODADA");
            }
            else if(fragment.equals(OitavaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 9º RODADA");
            }
            else if(fragment.equals(NonaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 10º RODADA");
            }
            else if(fragment.equals(DecimaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 1º RODADA");
            }
            else if(fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 2º RODADA");
            }
            else if(fragment.equals(DecimaSegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 3º RODADA");
            }
            else if(fragment.equals(DecimaTerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 4º RODADA");
            }
            else if(fragment.equals(DecimaQuartaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 5º RODADA");
            }
        }
        else if(direcao == 0){
            if(fragment.equals(DecimaQuintaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 4º RODADA");
            }
            else if(fragment.equals(DecimaQuartaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 3º RODADA");
            }
            else if(fragment.equals(DecimaTerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 2º RODADA");
            }
            else if(fragment.equals(DecimaSegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("2º TURNO - 1º RODADA");
            }
            else if(fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 10º RODADA");
            }
            else if(fragment.equals(DecimaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 9º RODADA");
            }
            else if(fragment.equals(NonaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 8º RODADA");
            }
            else if(fragment.equals(OitavaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 7º RODADA");
            }
            else if(fragment.equals(SetimaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 6º RODADA");
            }
            else if(fragment.equals(SextaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 5º RODADA");
            }
            else if(fragment.equals(QuintaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 4º RODADA");
            }
            else if(fragment.equals(QuartaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 3º RODADA");
            }
            else if(fragment.equals(TerceiraRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 2º RODADA");
            }
            else if (fragment.equals(SegundaRodadaFragment.getInstance())){
                navegacaoRodadasHelper.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadasHelper.setRodada("1º TURNO - 1º RODADA");
            }
        }

        return navegacaoRodadasHelper;
    }
}
>>>>>>> repo-pamela/master
