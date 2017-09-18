package br.com.futeboldospais.futeboldospais.controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.futeboldospais.futeboldospais.views.ArtilhariaFragment;
import br.com.futeboldospais.futeboldospais.views.ClassificacaoFragment;
import br.com.futeboldospais.futeboldospais.views.SuspensoesFragment;
import br.com.futeboldospais.futeboldospais.views.JogosFragment;
import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    private Fragment fragmentoSelecionado = null;

    /**
     * Listener do BottomNavigationView
     * Instancia um determinado fragment de acordo com o item clicado
     * Inicia uma transação entre fragments
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.item_jogos:
                    fragmentoSelecionado = JogosFragment.newInstance();
                    break;
                case R.id.item_classificacao:
                    fragmentoSelecionado = ClassificacaoFragment.newInstance();
                    break;
                case R.id.item_artilharia:
                    fragmentoSelecionado = ArtilhariaFragment.newInstance();
                    break;
                case R.id.item_suspensoes:
                    fragmentoSelecionado = SuspensoesFragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content, fragmentoSelecionado);
            transaction.commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Teste para trocar o tema da aplicação
        SharedPreferences.Editor editor = getSharedPreferences("pref", MODE_PRIVATE).edit();
        editor.putInt("teste", 1);
        editor.commit();

        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        int teste = pref.getInt("teste", 0);

        if(teste == 0) {
            super.setTheme(R.style.AppTheme);

        }
        else if(teste == 1){
            super.setTheme(R.style.AppTheme2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia o BottomNavigationView
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //Chama o metodo de desabilitar o movimento dos itens da classe BottomNavigationViewHelper
        BottomNavigationViewHelper.disableShiftMode(navigation);
        //Adiciona o listener ao BottomNavigation instanciado
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Inicia uma transação com o fragmento selecionado ao criar a view
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, JogosFragment.newInstance());
        transaction.commit();
    }

}
