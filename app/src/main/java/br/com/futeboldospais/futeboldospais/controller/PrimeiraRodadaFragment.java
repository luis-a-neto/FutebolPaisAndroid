package br.com.futeboldospais.futeboldospais.controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.ResultadoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiraRodadaFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static PrimeiraRodadaFragment fragment = null;

    public static PrimeiraRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new PrimeiraRodadaFragment();
        }
        return fragment;
    }

    public static PrimeiraRodadaFragment getInstance(){
        return fragment;
    }

    private ListView tabelaResultado;
    private Resultado[] listaResultado;
    private ResultadoService resultadoService;
    private ResultadoAdapter adapter;

    public PrimeiraRodadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeira_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.primeira_rodada_tabela);
        Log.d("teste", "adapter fragment");

        resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 1, 1);
        adapter = new ResultadoAdapter(listaResultado, getActivity());
        tabelaResultado.setAdapter(adapter);

        tabelaResultado.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ResultadoAdapter item = (ResultadoAdapter) parent.getItemAtPosition(position);
                String url = item.getItemUrl(position);

                Intent intent = new Intent(getContext(), DocumentViewer.class);
                intent.putExtra("title", "Súmula");
                intent.putExtra("url", url);

                startActivity(intent);
            }

        });

        return view;
    }



}
