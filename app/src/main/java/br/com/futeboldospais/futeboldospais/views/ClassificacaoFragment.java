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
public class ClassificacaoFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ClassificacaoFragment fragment = null;

    public static ClassificacaoFragment newInstance() {
        if (fragment == null) {
            fragment = new ClassificacaoFragment();
        }
        return fragment;
    }

    public ClassificacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classificacao, container, false);
    }

}
