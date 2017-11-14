<<<<<<< HEAD
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
public class SegundaRodadaFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static SegundaRodadaFragment fragment = null;

    public static SegundaRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new SegundaRodadaFragment();
        }
        return fragment;
    }

    public static SegundaRodadaFragment getInstance(){
        return fragment;
    }

    private ListView tabelaResultado;
    private Resultado[] listaResultado;
    private ResultadoService resultadoService;
    private ResultadoAdapter adapter;

    public SegundaRodadaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segunda_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.segunda_rodada_tabela);
        Log.d("teste", "adapter fragment");


        resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 2, 1);
        adapter = new ResultadoAdapter(listaResultado, getActivity());
        tabelaResultado.setAdapter(adapter);

        return view;
    }

}
=======
package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Jogo;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.JogoService;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.JogoAdapter;
import br.com.futeboldospais.futeboldospais.util.ResultadoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundaRodadaFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static SegundaRodadaFragment fragment = null;

    public static SegundaRodadaFragment newInstance() {
        if (fragment == null) {
            fragment = new SegundaRodadaFragment();
        }
        return fragment;
    }

    public static SegundaRodadaFragment getInstance() {
        return fragment;
    }

    private ListView tabelaResultado;
    private ListView tabelaResultadoVazio;
    private Resultado[] listaResultado;
    private Jogo[] listaJogo;
    private ResultadoService resultadoService;
    private JogoService jogoService;
    private ResultadoAdapter resultadoAdapter;
    private JogoAdapter jogoAdapter;

    public SegundaRodadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segunda_rodada, container, false);

        tabelaResultado = (ListView) view.findViewById(R.id.segunda_rodada_tabela);
        tabelaResultadoVazio = (ListView) view.findViewById(R.id.segunda_rodada_tabela_vazia);
        Log.d("teste", "adapter fragment");

        resultadoService = new ResultadoService();
        listaResultado = resultadoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 2, 1);

        jogoService = new JogoService();
        listaJogo = jogoService.listarDadosPorRodadaETurno(getActivity().getBaseContext(), 2, 1);

        if (listaResultado != null) {
            Log.d("teste", "lista resultado nao é nulo");

            if (listaResultado.length == 6) {
                Log.d("teste", "lista resultado é igual a 6");

                resultadoAdapter = new ResultadoAdapter(listaResultado, getActivity());
                tabelaResultado.setAdapter(resultadoAdapter);

            } else if (listaResultado.length < 6) {
                Log.d("teste", "lista resultado é menor que 6");

                resultadoAdapter = new ResultadoAdapter(listaResultado, getActivity());
                tabelaResultado.setAdapter(resultadoAdapter);

                if (listaJogo != null) {
                    jogoAdapter = new JogoAdapter(listaJogo, getActivity());
                    tabelaResultadoVazio.setAdapter(jogoAdapter);
                }
            }
        } else if (listaJogo != null) {
            Log.d("teste", "lista resultado é nulo");

            jogoAdapter = new JogoAdapter(listaJogo, getActivity());
            tabelaResultadoVazio.setAdapter(jogoAdapter);
        } else {
            String rs = "Resultados não encontrados";
        }

        return view;
    }
}
>>>>>>> repo-pamela/master
