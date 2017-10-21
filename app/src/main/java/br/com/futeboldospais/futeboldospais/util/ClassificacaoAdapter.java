package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;

/**
 * Created by danieldea on 28/09/2017.
 */

public class ClassificacaoAdapter extends BaseAdapter{

    private Classificacao[] listaClassificacao;
    private Context context;

    public ClassificacaoAdapter(Classificacao[] classificacaos, Context context){
        Log.d("teste", "construtor");
        this.listaClassificacao = classificacaos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaClassificacao.length;
    }

    @Override
    public Object getItem(int position) {
        return listaClassificacao[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = convertView;
        if(view == null) {

            Log.d("teste", "hahahaha");
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            Log.d("teste", "Embaixo do inflater");
            view = inflater.inflate(R.layout.linha_classificacao, parent, false);

            TextView posicao = (TextView) view.findViewById(R.id.posicao);
            TextView equipe = (TextView) view.findViewById(R.id.equipe);
            TextView pontosGanhos = (TextView) view.findViewById(R.id.pontos_ganhos);
            TextView jogos = (TextView) view.findViewById(R.id.jogos);
            TextView vitorias = (TextView) view.findViewById(R.id.vitorias);
            TextView saldoGols = (TextView) view.findViewById(R.id.saldo_gols);
            Log.d("teste", "Abaixo dos Find");

            ViewHolderClassificacao viewHolderClassificacao = new ViewHolderClassificacao(posicao, equipe, pontosGanhos, jogos, vitorias, saldoGols);
            Log.d("teste", "Abaixo do viewholder");

            view.setTag(viewHolderClassificacao);
            Log.d("teste", "Seto a tag");
        }

        ViewHolderClassificacao viewHolderClassificacao = (ViewHolderClassificacao)view.getTag();
        Log.d("teste", "Pego a tag");
        viewHolderClassificacao.getPosicao().setText(String.valueOf(position + 1) + "º");
        viewHolderClassificacao.getEquipe().setText(listaClassificacao[position].getEquipe());
        Log.d("teste", "Carregou o viewholder 1");
        viewHolderClassificacao.getPontosGanhos().setText(String.valueOf(listaClassificacao[position].getPontosGanhos()));
        Log.d("teste", "Carregou o viewholder 2");
        viewHolderClassificacao.getJogos().setText(String.valueOf(listaClassificacao[position].getJogos()));
        Log.d("teste", "Carregou o viewholder 3");
        viewHolderClassificacao.getVitorias().setText(String.valueOf(listaClassificacao[position].getVitorias()));
        Log.d("teste", "Carregou o viewholder 4");
        viewHolderClassificacao.getSaldoGols().setText(String.valueOf(listaClassificacao[position].getSaldoGols()));
        Log.d("teste", "Carregou o viewholder final");

        return view;
    }
}
