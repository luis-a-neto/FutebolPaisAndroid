package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;

/**
 * Created by ThirdSystem on 29/10/2017.
 */

public class AdapterPadrao extends BaseAdapter {

    String[] vetor;
    private Context context;

    public AdapterPadrao(Context context) {
        vetor = new String[1];
        vetor[0] = "Opa, não tem ninguem aqui ainda!";
        this.context = context;
    }

    @Override
    public int getCount() {
        return vetor.length;
    }

    @Override
    public Object getItem(int position) {
        return vetor[position];
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

            view = inflater.inflate(R.layout.linha_padrao, parent, false);

            TextView padrao = (TextView) view.findViewById(R.id.lbl_padrao);

            ViewHolderPadrao viewHolderPadrao = new ViewHolderPadrao(padrao);

            view.setTag(viewHolderPadrao);
        }

        ViewHolderPadrao viewHolderPadrao = (ViewHolderPadrao) view.getTag();
        viewHolderPadrao.getPadrao().setText(vetor[position]);

        return view;
    }
}
