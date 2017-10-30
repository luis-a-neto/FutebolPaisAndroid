package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

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

    private RadioButton rbtAmarelo;
    private RadioButton rbtVermelho;

    public CartoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_cartoes, container, false);


        rbtVermelho = (RadioButton) view.findViewById(R.id.rbt_vermelho);
        rbtVermelho.setChecked(false);

        rbtAmarelo = (RadioButton) view.findViewById(R.id.rbt_amarelo);
        rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));
        rbtAmarelo.setChecked(true);

        rbtAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));

                rbtVermelho.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtVermelho.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_branco));
            }
        });

        rbtVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_branco));

                rbtVermelho.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtVermelho.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_cinza));
            }
        });



        // Inflate the layout for this fragment
        return view;
    }

}
