package br.com.futeboldospais.futeboldospais.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.FileDownloadHelper;

/**
    Projeto:    FutebolPaisAndroid
    Arquivo:    DocumentViewer.java
    Autor:      Luis Andrade
    Data:       22.09.2017

    Activity de visualizador de documentos. A mesma é reutilizável, com o intuito
    de permitir a visualização de súmulas (PDF/JPEG) e regulamentos (PDF).
    O intent deverá trazer nos extras as seguintes strings:
    - url (o documento a ser exibido)
    - title (o título a ser exibido na janela)

    Utiliza-se aqui uma Toolbar com o intuito de fornecer uma "barra de título" para a janela,
    consistente com as User Interface Guidelines do Android. (Sem reinventar a roda aqui, folks!)

    Dependências: com.github.barteksc:android-pdf-viewer:2.7.0 (adicionar ao build.gradle).

    Histórico de modificações:
    Data ______ Autor _________________ Resumo ___________________________________________________
    22.09.2017  Luis Andrade            Inicial
    01.11.2017  Luis Andrade            Readequação da arquitetura de multithreading
 **/

public class DocumentViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // Obrigatório!
        Intent intent = getIntent(); // Traz o intent para o nosso contexto

        // Pega do intent as variáveis necessárias
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");

        setContentView(R.layout.activity_document_viewer); // Configura o layout

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Instancia a barra superior...
        setSupportActionBar(toolbar); // ...e a configura como barra superior.

        // Configura o título da janela
        toolbar.setTitle(title);

        // Joga o contexto como variável final; precisaremos disso ao chamar o FileDownloadHelper.
        // Como vamos acessar ela a partir de uma inner class, ela tem que ser final. Java, né...
        final Context context = this;

        // Aqui é que a onça bebe água. Instancia uma nova thread runnable...
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    try {
                        // Baixa o PDF.
                        final InputStream pdfDocument =
                                FileDownloadHelper.downloadBinary(context, "url");

                        // Pega o PDF baixado e o exibe na PDFView da activity.
                        runOnUiThread(
                            new Runnable(){
                                @Override
                                public void run() {
                                    // Exibe o PDF.
                                    PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
                                    pdfView.fromStream(pdfDocument);
                                    pdfView.fitToWidth();
                                }
                            }
                        );
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        ).start();
    }
}
