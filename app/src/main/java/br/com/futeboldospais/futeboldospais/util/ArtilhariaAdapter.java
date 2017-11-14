<<<<<<< HEAD
package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Artilharia;

/**
 * Created by Pâmela e Vinicius on 30/09/2017.
 */

public class ArtilhariaAdapter extends BaseAdapter  {

    private Artilharia[] listaArtilharia;
    private Context context;

    public ArtilhariaAdapter(Artilharia[] listaArtilharia, Context context) {
        this.listaArtilharia = listaArtilharia;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaArtilharia.length;
    }

    @Override
    public Object getItem(int position) {
        return listaArtilharia[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            view = inflater.inflate(R.layout.linha_artilharia, parent, false);

            TextView nome = (TextView) view.findViewById(R.id.txt_artilheiro);
            TextView numero = (TextView) view.findViewById(R.id.txt_numero);
            TextView posicao_artilheiro = (TextView) view.findViewById(R.id.txt_posicao);
            TextView equipe = (TextView) view.findViewById(R.id.txt_equipe);


            ViewHolderArtilharia viewHolderArtilharia = new ViewHolderArtilharia(nome, numero, posicao_artilheiro, equipe);

            view.setTag(viewHolderArtilharia);
        }

        ViewHolderArtilharia viewHolderArtilharia = (ViewHolderArtilharia) view.getTag();
        viewHolderArtilharia.getNome().setText(listaArtilharia[posicao].getNome());
        viewHolderArtilharia.getNumero().setText(String.valueOf(listaArtilharia[posicao].getNumero()));
        viewHolderArtilharia.getPosicao().setText(listaArtilharia[posicao].getPosicao());
        viewHolderArtilharia.getEquipe().setText(listaArtilharia[posicao].getEquipe());

        return view;
    }
}


=======
package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by Pâmela e Vinicius on 30/09/2017.
 */

public class ArtilhariaAdapter extends BaseAdapter  {

    private DistintivoService distintivoService;
    private Artilharia[] listaArtilharia;
    private Context context;
    int count;

    public ArtilhariaAdapter(Artilharia[] listaArtilharia, Context context) {
        this.listaArtilharia = listaArtilharia;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaArtilharia.length;
    }

    @Override
    public Object getItem(int position) {
        return listaArtilharia[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

            view = inflater.inflate(R.layout.linha_artilharia, parent, false);

            TextView top = (TextView) view.findViewById(R.id.txt_top_3);
            ImageView equipe = (ImageView) view.findViewById(R.id.escudo_equipe);
            TextView jogador = (TextView) view.findViewById(R.id.txt_artilheiro);
            TextView posicao = (TextView) view.findViewById(R.id.txt_posicao);
            TextView gols = (TextView) view.findViewById(R.id.txt_gols);

            ViewHolderArtilharia viewHolderArtilharia = new ViewHolderArtilharia(top, equipe, jogador, posicao, gols);
            view.setTag(viewHolderArtilharia);

            distintivoService = new DistintivoService();
        }

        count = count + 1;
        Log.d("Teste", "Contador: " + String.valueOf(count));
        Log.d("Teste", "Position: " + String.valueOf(position));
        Log.d("Teste", "Tamanho passado: " + String.valueOf(listaArtilharia.length));

        ViewHolderArtilharia viewHolderArtilharia = (ViewHolderArtilharia) view.getTag();
        int gols = 0;
        if(listaArtilharia[position].getGols() > gols) {
            gols = listaArtilharia[position].getGols();
            viewHolderArtilharia.getTop().setText(String.valueOf(position + 1));
        }
        try {
            viewHolderArtilharia.getEquipe().setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), listaArtilharia[position].getEquipe()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolderArtilharia.getJogador().setText(listaArtilharia[position].getNome());
        viewHolderArtilharia.getPosicao().setText(listaArtilharia[position].getPosicao().toUpperCase());
        viewHolderArtilharia.getGols().setText(String.valueOf(listaArtilharia[position].getGols()));

        return view;
    }
}


>>>>>>> repo-pamela/master
