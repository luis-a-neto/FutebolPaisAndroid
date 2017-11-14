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


