package br.com.futeboldospais.futeboldospais.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.NavegacaoRodadas;


/**
 * A simple {@link Fragment} subclass.
 */
public class JogosFragment extends Fragment{

    private Button btnProximaRodada;
    private Button btnRodadaAnterior;
    private TextView txtRodada;

    private RadioButton rbtMaster;
    private RadioButton rbtSenior;
    private RadioButton rbtTodos;

    //Rodada atual chumbada
    private String rodada = "2º Turno - 2º Rodada";
    private Fragment fragmentoSelecionado = SegundaRodadaFragment.newInstance();

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static JogosFragment fragment = null;

    public static JogosFragment newInstance() {
        if (fragment == null) {
            fragment = new JogosFragment();
        }
        return fragment;
    }

    public JogosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_jogos, container, false);

        rbtMaster = (RadioButton) view.findViewById(R.id.rbt_master);
        rbtSenior = (RadioButton) view.findViewById(R.id.rbt_senior);
        rbtTodos = (RadioButton) view.findViewById(R.id.rbt_todos);

        rbtTodos.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtTodos.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.gray));

        //Inicia uma transação com o fragmento selecionado ao criar a view
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
        transaction.commit();

        txtRodada = (TextView) view.findViewById(R.id.txt_rodada);
        txtRodada.setText(rodada);

        //Botão para voltar uma rodada
        btnRodadaAnterior = (Button) view.findViewById(R.id.btn_anterior);
        btnRodadaAnterior.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Chama a classe NavegaçãoRodadas para receber um titulo de rodada e uma instancia da rodada anterior
                rodada = NavegacaoRodadas.selecionaRodada(NavegacaoRodadas.ANTERIOR, fragmentoSelecionado).getRodada();
                fragmentoSelecionado = NavegacaoRodadas.selecionaRodada(NavegacaoRodadas.ANTERIOR, fragmentoSelecionado).getFragmentoSelecionado();
                txtRodada.setText(rodada);
                //Inicia a transação entre fragments
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                transaction.commit();
            }
        });

        //Botão para avançar uma rodada
        btnProximaRodada = (Button) view.findViewById(R.id.btn_proximo);
        btnProximaRodada.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Chama a classe NavegaçãoRodadas para receber um titulo de rodada e uma instancia da proxima rodada
                rodada = NavegacaoRodadas.selecionaRodada(NavegacaoRodadas.PROXIMO, fragmentoSelecionado).getRodada();
                fragmentoSelecionado = NavegacaoRodadas.selecionaRodada(NavegacaoRodadas.PROXIMO, fragmentoSelecionado).getFragmentoSelecionado();
                txtRodada.setText(rodada);
                //Inicia a transação entre fragments
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                transaction.commit();
            }
        });

        rbtMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_cinza));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_branco));

                rbtTodos.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtTodos.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            }
        });

        rbtSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_branco));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_cinza));

                rbtTodos.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtTodos.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            }
        });

        rbtTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_esq_branco));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.arredondar_borda_dir_branco));

                rbtTodos.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtTodos.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.gray));
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
