package br.com.futeboldospais.futeboldospais.views;


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
public class ArtilhariaFragment extends Fragment {

    private RadioButton rbtMaster;
    private RadioButton rbtSenior;
    private RadioButton rbtTodos;

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ArtilhariaFragment fragment = null;

    public static ArtilhariaFragment newInstance() {
        if (fragment == null) {
            fragment = new ArtilhariaFragment();
        }
        return fragment;
    }


    public ArtilhariaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_artilharia, container, false);
        
        rbtMaster = (RadioButton) view.findViewById(R.id.rbt_master);
        rbtSenior = (RadioButton) view.findViewById(R.id.rbt_senior);

        rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));

        rbtMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_branco));
            }
        });

        rbtSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_branco));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_cinza));
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

}
