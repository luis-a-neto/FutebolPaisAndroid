package br.com.futeboldospais.futeboldospais.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.futeboldospais.futeboldospais.ServicoAtualizacao;
import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Atualizacao;
import br.com.futeboldospais.futeboldospais.model.Configuracao;
import br.com.futeboldospais.futeboldospais.service.ConfiguracaoService;

public class MainActivity extends AppCompatActivity {

    private TextView lblStatus;
    private TextView lblUltimaAtualizacaoEsq;
    private TextView lblUltimaAtualizacaoDir;
    private TextView lblCampeonato;
    private TextView lblHomenageado;
    private Button btnProseguirDadosLocais;
    private Button btnTentarNovamente;
    private ProgressBar atualizacaoStatus;
    private LinearLayout div2;
    private LinearLayout div3;
    private LinearLayout div4;
    private Activity activity;
    private Configuracao configuracao;
    private String ultimaAtualizacao;

    ConfiguracaoService configuracaoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esconde a barra de status
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        activity = this;
        initComponents();
        sincronizarAtualizacao();
    }

    private class StatusReceiver extends ResultReceiver {

        private StatusReceiver(Handler handler) {
            super(handler);
        }

        @Override
        public void onReceiveResult(int resultCode, Bundle dados) {
            super.onReceiveResult(resultCode, dados);
            if (resultCode == Atualizacao.RESULT_CODE) {

                int statusConexao = dados.getInt(Atualizacao.STATUS_CONEXAO);
                Log.d("teste", "status conexao: " + String.valueOf(statusConexao));
                int verificarAtualizacao = dados.getInt(Atualizacao.VERIFICAR_ATUALIZACAO);
                Log.d("teste", "atualizacao verificada: " + String.valueOf(verificarAtualizacao));
                int statusAtualizacao = dados.getInt(Atualizacao.STATUS_ATUALIZACAO);
                Log.d("teste", "status atualizacao: " + String.valueOf(statusAtualizacao));

                verificarStatusConexao(statusConexao);

                verificarExistenciaAtualizacao(verificarAtualizacao);

                verificarStatusAtualizacao(statusAtualizacao);
            }
        }

        private void verificarStatusConexao(int statusConexao) {
            if (statusConexao != 0) {
                if (statusConexao == 1) {
                    lblStatus.setText("Verificando atualizações...");
                    btnProseguirDadosLocais.setVisibility(View.INVISIBLE);
                    div3.setVisibility(View.VISIBLE);
                    div2.setVisibility(View.INVISIBLE);
                } else if (statusConexao == 2) {
                    if (ultimaAtualizacao != null) {
                        btnProseguirDadosLocais.setVisibility(View.VISIBLE);
                    }
                    div3.setVisibility(View.INVISIBLE);
                    div2.setVisibility(View.VISIBLE);
                    Toast.makeText(activity, "Não foi possível verificar atualizações", Toast.LENGTH_SHORT).show();
                }
            }
        }

        private void verificarExistenciaAtualizacao(int verificarAtualizacao) {
            if (verificarAtualizacao != 0) {
                if (verificarAtualizacao == 1) {
                    lblStatus.setText("Atualizando dados...");
                } else if (verificarAtualizacao == 2) {
                    lblStatus.setText("Sem atualizações disponíveis.");
                    if (!activity.isDestroyed()) {
                        iniciarMenuPrincipalComAtraso();
                    }
                } else if (verificarAtualizacao == 3) {
                    if (ultimaAtualizacao != null) {
                        btnProseguirDadosLocais.setVisibility(View.VISIBLE);
                    }
                    div3.setVisibility(View.INVISIBLE);
                    div2.setVisibility(View.VISIBLE);
                    Toast.makeText(activity, "Erro ao tentar verificar atualizações", Toast.LENGTH_SHORT).show();
                }
            }
        }

        private void verificarStatusAtualizacao(int statusAtualizacao) {
            if (statusAtualizacao != 0) {
                if (statusAtualizacao == 1) {
                    lblStatus.setText("Dados atualizados com sucesso.");
                    if (!activity.isDestroyed()) {
                        iniciarMenuPrincipalComAtraso();
                    }
                } else if (statusAtualizacao == 2) {
                    if (ultimaAtualizacao != null) {
                        btnProseguirDadosLocais.setVisibility(View.VISIBLE);
                    }
                    div3.setVisibility(View.INVISIBLE);
                    div2.setVisibility(View.VISIBLE);
                    Toast.makeText(activity, "Ocorreu um erro ao tentar atualizar", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initComponents() {
        div2 = (LinearLayout) findViewById(R.id.div2);
        div3 = (LinearLayout) findViewById(R.id.div3);
        div4 = (LinearLayout) findViewById(R.id.div4);

        btnProseguirDadosLocais = (Button) findViewById(R.id.btn_dados_locais);
        btnTentarNovamente = (Button) findViewById(R.id.btn_tentar_novamente);

        lblStatus = (TextView) findViewById(R.id.lbl_status);
        lblUltimaAtualizacaoDir = (TextView) findViewById(R.id.lbl_ultima_atualizacao_dir);
        lblUltimaAtualizacaoEsq = (TextView) findViewById(R.id.lbl_ultima_atualizacao_esq);
        lblCampeonato = (TextView) findViewById(R.id.lbl_campeonato);
        lblHomenageado = (TextView) findViewById(R.id.lbl_homenageado);

        atualizacaoStatus = (ProgressBar) findViewById(R.id.timer);

        btnProseguirDadosLocais.setVisibility(View.INVISIBLE);

        div2.setVisibility(View.INVISIBLE);
        div3.setVisibility(View.VISIBLE);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/open_sans_light.ttf");
        lblStatus.setTypeface(font);
        btnProseguirDadosLocais.setTypeface(font);
        btnTentarNovamente.setTypeface(font);
        lblUltimaAtualizacaoDir.setTypeface(font);
        lblUltimaAtualizacaoEsq.setTypeface(font);
        lblCampeonato.setTypeface(font);
        lblHomenageado.setTypeface(font);
    }

    private void sincronizarAtualizacao() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                configuracaoService = new ConfiguracaoService();
                Log.d("teste", "instanciou configuracao service");
                ultimaAtualizacao = configuracaoService.getUltimaAtualizacao(getBaseContext());
                Log.d("teste", "carregou ultima atualizacao: " + ultimaAtualizacao);
                configuracao = configuracaoService.listarDados(getBaseContext());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("teste", "ira iniciar o serviço");
                        iniciarServiço();

                        Log.d("teste", "entrou na ui thread");
                        if (ultimaAtualizacao != null) {
                            lblUltimaAtualizacaoDir.setText(ultimaAtualizacao);
                            String temaCampeonato = configuracao.getTema() + " " + String.valueOf(configuracao.getCampeonatoAno());
                            lblCampeonato.setText(temaCampeonato.toUpperCase());
                            lblHomenageado.setText(configuracao.getHomenageado().toUpperCase());
                            Log.d("teste", "setou ultima atualizacao");
                        } else {
                            Log.d("teste", "ultima atualizacao esta nulo");
                            div4.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        }).start();
    }

    private void iniciarMenuPrincipal() {
        Intent intent = new Intent(activity, MenuPrincipalActivity.class);
        startActivity(intent);
        activity.finish();
    }

    private void iniciarMenuPrincipalComAtraso() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(500);

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(activity, MenuPrincipalActivity.class);
                            startActivity(intent);
                            activity.finish();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void iniciarServiço() {
        Intent intentService = new Intent(this, ServicoAtualizacao.class);
        intentService.putExtra(Atualizacao.RECEPTOR, new StatusReceiver(new Handler()));
        startService(intentService);
    }

    public void onClickView(View view) {
        //Esconde a barra de status
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void tentarNovamente(View view) {
        iniciarServiço();
    }

    public void prosseguirSemAtualizar(View view) {
        iniciarMenuPrincipal();
    }
}
