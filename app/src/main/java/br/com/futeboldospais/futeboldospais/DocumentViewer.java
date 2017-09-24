package br.com.futeboldospais.futeboldospais;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;

import java.util.List;

/**
    Projeto:    FutebolPaisAndroid
    Arquivo:    DocumentViewer.java
    Autor:      Luis Andrade
    Data:       22.09.2017

    Activity de visualizador de documentos. A mesma é reutilizável, com o intuito
    de permitir a visualização de súmulas (PDF/JPEG) e regulamentos (PDF).

    O intent deverá trazer nos extras as seguintes strings:
    - uri (o endereço/URI do documento a ser baixado)
    - title (o título a ser exibido na janela)
    Os mesmos nomes são utilizados pelas variáveis durante a classe.

    Utiliza-se aqui uma Toolbar com o intuito de fornecer uma "barra de título" para a janela,
    consistente com as User Interface Guidelines do Android. (Sem reinventar a roda aqui, folks!)

    Dependências: com.github.barteksc:android-pdf-viewer:2.7.0 (adicionar ao build.gradle).

    Histórico de modificações:
    Data ______ Autor _________________ Resumo ___________________________________________________
    22.09.2017  Luis Andrade            Inicial
 */

public class DocumentViewer extends AppCompatActivity {

    // Declaração das duas variáveis utilizadas neste processo.
    String uri, title, mimeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // Obrigatório!
        Intent intent = getIntent(); // Traz o intent para o nosso contexto

        setContentView(R.layout.activity_document_viewer); // Configura o layout

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Instancia a barra superior...
        setSupportActionBar(toolbar); // ...e a configura como barra superior.

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        ImageView imageView = (ImageView) findViewById(R.id.jpgView);

        // Pega do intent as variáveis necessárias
        uri = intent.getStringExtra("uri");
        title = intent.getStringExtra("title");

        Uri resource = Uri.parse(uri);
        mimeType = MimeTypeMap.getFileExtensionFromUrl(uri);

        // Configura o título da janela
        toolbar.setTitle(title);

        // Aqui que a onça bebe água.
        // TODO: Baixar o documento, determinar o MIME Type
        // TODO: Esconder os widgets de acordo com o MIME Type

        if ( mimeType.equals("application/x-pdf" )){
            // PDF
        }
        else if ( mimeType.equals("image/jpeg")){
            // JPEG
        }
        else {
            // Se não for um, nem outro... cuspir erro.
        }

    }

}
