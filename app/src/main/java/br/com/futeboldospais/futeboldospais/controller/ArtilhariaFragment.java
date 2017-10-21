package br.com.futeboldospais.futeboldospais.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.ArtilhariaAdapter;
import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.service.ArtilhariaService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtilhariaFragment extends Fragment {

    private RadioButton rbtMaster;
    private RadioButton rbtSenior;
    private ListView listView;
    private Artilharia[] listaArtilharia;
    private ArtilhariaAdapter adapter;
    private Fragment activity;
    private ArtilhariaService artilhariaService;

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

    /**
     * Criado por: Pâmela e Vinicius em 13/09/2017
     *
     * Alterado por: Daniel Almeida
     * Objetivo: Otimizar a mecanica de navegação
     * Data alteração: 14/09/2017
     *
     * Alterado por: Pâmela e Vinicius
     * Objetivo: inclusão da lista de artilharias
     * Dt. alteração: 18.10.2017
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.activity = this;

        final View view = inflater.inflate(R.layout.fragment_artilharia, container, false);

        rbtSenior = (RadioButton) view.findViewById(R.id.rbt_senior);
        rbtSenior.setChecked(false);

        rbtMaster = (RadioButton) view.findViewById(R.id.rbt_master);
        rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));
        rbtMaster.setChecked(true);

        listView = (ListView) view.findViewById(R.id.lista_melhores_jogadores);

        artilhariaService = new ArtilhariaService();
        listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity().getBaseContext(), "Master");
        Log.d("teste","lista por categoria");
        adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
        Log.d("teste", "adapter");
        listView.setAdapter(adapter);


        rbtMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity().getBaseContext(), "Master");

                adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());

                listView.setAdapter(adapter);

                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_branco));
            }
        });

        rbtSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity().getBaseContext(), "Senior");

                adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());

                listView.setAdapter(adapter);

                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_branco));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_cinza));
            }
        });

        return view;
    }
}