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
public class SuspensosFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 23/10/2017.
     * Cria um singleton da classe
     */
    private static SuspensosFragment fragment = null;

    public static SuspensosFragment newInstance() {
        if (fragment == null) {
            fragment = new SuspensosFragment();
        }
        return fragment;
    }

    public SuspensosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suspensos, container, false);
    }

}
