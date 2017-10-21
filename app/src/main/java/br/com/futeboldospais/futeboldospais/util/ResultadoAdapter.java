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
import br.com.futeboldospais.futeboldospais.model.Resultado;

/**
 * Created by luis on 18/10/17.
 */

public class ResultadoAdapter extends BaseAdapter{

        private Resultado[] listaResultado;
        private Activity activity;

        public ResultadoAdapter(Resultado[] listaResultado, Activity activity) {
            this.listaResultado = listaResultado;
            this.activity = activity;
        }

        @Override
        public int getCount() {
            return listaResultado.length;
        }

        @Override
        public Object getItem(int position) {
            return listaResultado[position];
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
                TextView estadio = (TextView) view.findViewById(R.id.estadio);

                ViewHolderResultado viewHolderResultado = new ViewHolderResultado(escudoCasa, escudoVisitante, timeCasa, timeVisitante, golsCasa, golsVisitante, dataHora, estadio);
                view.setTag(viewHolderResultado);
            }

            ViewHolderResultado viewHolderResultado = (ViewHolderResultado)view.getTag();

            viewHolderResultado.getDataHora().setText(listaResultado[position].getData() + " - " + listaResultado[position].getHorario());
            viewHolderResultado.getEstadio().setText(listaResultado[position].getCategoria());

            viewHolderResultado.getTimeCasa().setText(listaResultado[position].getEquipe1());
            viewHolderResultado.getTimeVisitante().setText(listaResultado[position].getEquipe2());

            viewHolderResultado.getGolsCasa().setText(String.valueOf(listaResultado[position].getGolsEquipe1()));
            viewHolderResultado.getGolsVisitante().setText(String.valueOf(listaResultado[position].getGolsEquipe2()));

            // Implementar
            viewHolderResultado.getEscudoCasa().setImageDrawable(null);
            viewHolderResultado.getEscudoVisitante().setImageDrawable(null);

            return view;
        }
}
