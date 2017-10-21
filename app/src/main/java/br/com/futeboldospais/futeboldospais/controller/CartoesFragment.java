package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.futeboldospais.futeboldospais.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartoesFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static CartoesFragment fragment = null;

    public static CartoesFragment newInstance() {
        if (fragment == null) {
            fragment = new CartoesFragment();
        }
        return fragment;
    }

    public CartoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartoes, container, false);
    }

}
