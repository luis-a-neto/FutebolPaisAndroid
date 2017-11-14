package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;

/**
 * Created by ThirdSystem on 24/10/2017.
 */

public class ClassificacaoAdapterDireita extends BaseAdapter {

    private Classificacao[] listaClassificacao;
    private Context context;

    public ClassificacaoAdapterDireita(Classificacao[] classificacaos, Context context) {
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
        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_classificacao_dir, parent, false);

            TextView pontosGanhos = (TextView) view.findViewById(R.id.pontos_ganhos);
            TextView jogos = (TextView) view.findViewById(R.id.jogos);
            TextView vitorias = (TextView) view.findViewById(R.id.vitorias);
            TextView empates = (TextView) view.findViewById(R.id.empates);
            TextView derrotas = (TextView) view.findViewById(R.id.derrotas);
            TextView golsPro = (TextView) view.findViewById(R.id.gols_pro);
            TextView golsContra = (TextView) view.findViewById(R.id.gols_contra);
            TextView saldoGols = (TextView) view.findViewById(R.id.saldo_gols);
            TextView cartoesAmarelos = (TextView) view.findViewById(R.id.cartoes_amarelos);
            TextView cartoesVermelhos = (TextView) view.findViewById(R.id.cartoes_vermelhos);
            TextView pontosDisciplinares = (TextView) view.findViewById(R.id.pontos_disciplinares);

            ViewHolderClassificacaoDireita viewHolderClassificacaoDireita = new ViewHolderClassificacaoDireita(pontosGanhos, jogos, vitorias, empates, derrotas, golsPro, golsContra, saldoGols, cartoesAmarelos, cartoesVermelhos, pontosDisciplinares);
            view.setTag(viewHolderClassificacaoDireita);
        }

        ViewHolderClassificacaoDireita viewHolderClassificacaoDireita = (ViewHolderClassificacaoDireita) view.getTag();

        viewHolderClassificacaoDireita.getPontosGanhos().setText(String.valueOf(listaClassificacao[position].getPontosGanhos()));
        viewHolderClassificacaoDireita.getJogos().setText(String.valueOf(listaClassificacao[position].getJogos()));
        viewHolderClassificacaoDireita.getVitorias().setText(String.valueOf(listaClassificacao[position].getVitorias()));
        viewHolderClassificacaoDireita.getEmpates().setText(String.valueOf(listaClassificacao[position].getEmpates()));
        viewHolderClassificacaoDireita.getDerrotas().setText(String.valueOf(listaClassificacao[position].getDerrotas()));
        viewHolderClassificacaoDireita.getGolsPro().setText(String.valueOf(listaClassificacao[position].getGolsPro()));
        viewHolderClassificacaoDireita.getGolsContra().setText(String.valueOf(listaClassificacao[position].getGolsContra()));
        viewHolderClassificacaoDireita.getSaldoGols().setText(String.valueOf(listaClassificacao[position].getSaldoGols()));
        viewHolderClassificacaoDireita.getCartoesAmarelos().setText(String.valueOf(listaClassificacao[position].getCartoesAmarelos()));
        viewHolderClassificacaoDireita.getCartoesVemelhos().setText(String.valueOf(listaClassificacao[position].getCartoesVermelhos()));
        viewHolderClassificacaoDireita.getPontosDisciplinares().setText(String.valueOf(((listaClassificacao[position].getCartoesAmarelos() * 1) + (listaClassificacao[position].getCartoesVermelhos() * 3))));

        return view;
    }
}
