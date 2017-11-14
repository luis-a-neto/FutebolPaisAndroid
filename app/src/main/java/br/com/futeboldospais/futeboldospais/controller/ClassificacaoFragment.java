<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.controller;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.TimeUtils;
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

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getContext(), DocumentViewer.class);
                intent.putExtra("title", "Súmula");
                intent.putExtra("url", "");

                startActivity(intent);
            }

        });

        // Inflate the layout for this fragment
        return view;
    }

}
=======
package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoService;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterDireita;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterEsquerda;


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

    private RadioButton rbtMaster;
    private RadioButton rbtSenior;
    private ListView tabelaClassificacaoEsq;
    private ListView tabelaClassificacaoDir;
    private Classificacao[] listaClassificacao;
    private ClassificacaoService classificacaoService;
    private ClassificacaoAdapterEsquerda adapterEsq;
    private ClassificacaoAdapterDireita adapterDir;

    public ClassificacaoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("teste", "criou");
        final View view = inflater.inflate(R.layout.fragment_classificacao, container, false);

        tabelaClassificacaoEsq = (ListView) view.findViewById(R.id.classificacao_tabela_esq);
        tabelaClassificacaoDir = (ListView) view.findViewById(R.id.classificacao_tabela_dir);
        Log.d("teste", "adapter fragment");


        classificacaoService = new ClassificacaoService();
        listaClassificacao = classificacaoService.listarDados(getActivity().getBaseContext());

        adapterDir = new ClassificacaoAdapterDireita(listaClassificacao, getActivity());
        tabelaClassificacaoDir.setAdapter(adapterDir);
        setListViewHeightBasedOnChildren(tabelaClassificacaoDir);

        adapterEsq = new ClassificacaoAdapterEsquerda(listaClassificacao, getActivity());
        tabelaClassificacaoEsq.setAdapter(adapterEsq);
        setListViewHeightBasedOnChildren(tabelaClassificacaoEsq);

        rbtSenior = (RadioButton) view.findViewById(R.id.rbt_senior);
        rbtSenior.setChecked(false);

        rbtMaster = (RadioButton) view.findViewById(R.id.rbt_master);
        rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));
        rbtMaster.setChecked(true);

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


        /*tabelaClassificacao.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //Intent intent = new Intent("", "");
                //intent.putExtra("", "");

                //startActivity(intent);
            }

        });*/

        // Inflate the layout for this fragment
        return view;
    }

    /**** Method for Setting the Height of the ListView dynamically.
     **** Hack to fix the issue of not showing all the items of the ListView
     **** when placed inside a ScrollView  ****/
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

}
>>>>>>> repo-pamela/master
