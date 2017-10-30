package br.com.futeboldospais.futeboldospais.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Jogo;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by ThirdSystem on 25/10/2017.
 */

public class JogoAdapter extends BaseAdapter {

    private DistintivoService distintivoService;
    private Jogo[] listaJogo;
    private Activity activity;

    public JogoAdapter(Jogo[] listaJogo, Activity activity) {
        this.listaJogo = listaJogo;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listaJogo.length;
    }

    @Override
    public Object getItem(int position) {
        return listaJogo[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_resultado, parent, false);

            // Adicionar todos os campos
            ImageView escudoCasa = (ImageView) view.findViewById(R.id.escudo_timeCasa);
            ImageView escudoVisitante = (ImageView) view.findViewById(R.id.escudo_timeVisitante);

            TextView timeCasa = (TextView) view.findViewById(R.id.nome_timeCasa);
            TextView timeVisitante = (TextView) view.findViewById(R.id.nome_timeVisitante);

            TextView golsCasa = (TextView) view.findViewById(R.id.gols_timeCasa);
            TextView golsVisitante = (TextView) view.findViewById(R.id.gols_timeVisitante);

            TextView dataHora = (TextView) view.findViewById(R.id.dataHora);
            TextView categoria = (TextView) view.findViewById(R.id.categoria);

            ViewHolderResultado viewHolderResultado = new ViewHolderResultado(escudoCasa, escudoVisitante, timeCasa, timeVisitante, golsCasa, golsVisitante, dataHora, categoria);
            view.setTag(viewHolderResultado);

            distintivoService = new DistintivoService();
        }

        ViewHolderResultado viewHolderResultado = (ViewHolderResultado)view.getTag();

        viewHolderResultado.getDataHora().setText(listaJogo[position].getData() + " - " + listaJogo[position].getHorario());
        viewHolderResultado.getCategoria().setText(listaJogo[position].getCategoria());

        viewHolderResultado.getTimeCasa().setText(listaJogo[position].getEquipe1());
        viewHolderResultado.getTimeVisitante().setText(listaJogo[position].getEquipe2());

        viewHolderResultado.getGolsCasa().setText(null);
        viewHolderResultado.getGolsVisitante().setText(null);

        // Implementar
        try {
            viewHolderResultado.getEscudoCasa().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaJogo[position].getEquipe1()));
            viewHolderResultado.getEscudoVisitante().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaJogo[position].getEquipe2()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //viewHolderResultado.getEscudoCasa().setImageDrawable(null);
        //viewHolderResultado.getEscudoCasa().setImageDrawable(null);

        return view;
    }
}
