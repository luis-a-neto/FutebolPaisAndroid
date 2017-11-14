package br.com.futeboldospais.futeboldospais.controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.BottomNavigationViewHelper;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Fragment fragmentoSelecionado = null;
    private static String SAVED_EVENT = "controleEvento";
    private int controleEvento;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_EVENT, controleEvento);
        Log.d("teste", String.valueOf(controleEvento));
    }

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
                    controleEvento = 0;
                    break;
                case R.id.item_classificacao:
                    fragmentoSelecionado = ClassificacaoFragment.newInstance();
                    controleEvento = 1;
                    break;
                case R.id.item_artilharia:
                    fragmentoSelecionado = ArtilhariaFragment.newInstance();
                    controleEvento = 2;
                    break;
                case R.id.item_cartoes:
                    fragmentoSelecionado = CartoesFragment.newInstance();
                    controleEvento = 3;
                    break;
                case R.id.item_suspensos:
                    fragmentoSelecionado = SuspensosFragment.newInstance();
                    controleEvento = 4;
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

        if (teste == 0) {
            super.setTheme(R.style.AppTheme);

        } else if (teste == 1) {
            super.setTheme(R.style.AppTheme4);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Instancia o BottomNavigationView
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        //Chama o metodo de desabilitar o movimento dos itens da classe BottomNavigationViewHelper
        BottomNavigationViewHelper.disableShiftMode(navigation);
        //Adiciona o listener ao BottomNavigation instanciado
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        int controle;

        if (savedInstanceState == null) {
            controle = 0;
        } else {
            controle = savedInstanceState.getInt(SAVED_EVENT);
            controleEvento = savedInstanceState.getInt(SAVED_EVENT);
        }

        switch (controle) {
            case 0:
                fragmentoSelecionado = JogosFragment.newInstance();
                break;
            case 1:
                fragmentoSelecionado = ClassificacaoFragment.newInstance();
                break;
            case 2:
                fragmentoSelecionado = ArtilhariaFragment.newInstance();
                break;
            case 3:
                fragmentoSelecionado = CartoesFragment.newInstance();
                break;
            case 4:
                fragmentoSelecionado = SuspensosFragment.newInstance();
                break;
        }

        //Inicia uma transação com o fragmento selecionado ao criar a view
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragmentoSelecionado);
        transaction.commit();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                BancoDadosHelper.FabricaDeConexao.criarBancoDados(getBaseContext());

                Intent intent = new Intent(getBaseContext(), ServicoAtualizacao.class);
                Log.d("teste", "1 - instanciou o intent");
                startService(intent);
                Log.d("teste", "1 - iniciou o servico");
            }
        }).start();*/

    }
}
