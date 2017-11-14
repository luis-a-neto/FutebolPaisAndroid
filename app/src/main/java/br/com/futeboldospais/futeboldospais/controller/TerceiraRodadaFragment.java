package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.ResultadoAdapter;


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

    private ListView tabelaResultado;
    private Resultado[] listaResultado;
    private ResultadoService resultadoService;
    private ResultadoAdapter adapter;


    public TerceiraRodadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_terceira_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.terceira_rodada_tabela);
        Log.d("teste", "adapter fragment");


        resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 3, 1);
        adapter = new ResultadoAdapter(listaResultado, getActivity());
        tabelaResultado.setAdapter(adapter);

        return view;
    }

}
