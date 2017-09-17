package br.com.futeboldospais.futeboldospais.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.futeboldospais.futeboldospais.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TerceiraRodadaFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static TerceiraRodadaFragment fragment = null;

    public static TerceiraRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new TerceiraRodadaFragment();
        }
        return fragment;
    }

    public static TerceiraRodadaFragment getInstance(){
        return fragment;
    }

    public TerceiraRodadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_terceira_rodada, container, false);
    }

}
