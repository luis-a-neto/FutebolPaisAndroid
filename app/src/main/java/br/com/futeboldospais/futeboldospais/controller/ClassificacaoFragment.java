package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoService;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapter;


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

    private ListView tabelaClassificacao;
    private Classificacao[] listaClassificacao;
    private ClassificacaoService classificacaoService;
    private ClassificacaoAdapter adapter;

    public ClassificacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("teste", "criou");
        final View view = inflater.inflate(R.layout.fragment_classificacao, container, false);

        tabelaClassificacao = (ListView) view.findViewById(R.id.classificacao_tabela);
        Log.d("teste", "adapter fragment");

        classificacaoService = new ClassificacaoService();
        listaClassificacao = classificacaoService.listarDados(getActivity().getBaseContext());
        adapter = new ClassificacaoAdapter(listaClassificacao, getActivity());
        tabelaClassificacao.setAdapter(adapter);

        tabelaClassificacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        /*    @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), DocumentViewer.class);
                intent.putExtra("title", "Súmula");
                intent.putExtra("url", "");

                startActivity(intent);
            } */

        });

        // Inflate the layout for this fragment
        return view;
    }

}
