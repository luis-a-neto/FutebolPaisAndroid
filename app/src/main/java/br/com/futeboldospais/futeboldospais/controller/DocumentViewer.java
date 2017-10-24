package br.com.futeboldospais.futeboldospais.controller;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.InputStream;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.rest.FileDownloadHelper;

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
 **/

public class DocumentViewer extends AppCompatActivity {

    // Declaração das variáveis utilizadas neste processo.
    String uri, title, mimeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // Obrigatório!
        Intent intent = getIntent(); // Traz o intent para o nosso contexto

        setContentView(R.layout.activity_document_viewer); // Configura o layout

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Instancia a barra superior...
        setSupportActionBar(toolbar); // ...e a configura como barra superior.

        // Pega do intent as variáveis necessárias
        uri = intent.getStringExtra("uri");
        title = intent.getStringExtra("title");

        Uri resource = Uri.parse(uri);
        mimeType = MimeTypeMap.getFileExtensionFromUrl(uri);

        // Configura o título da janela
        toolbar.setTitle(title);

        // Aqui é que a onça bebe água.
        if ( mimeType.equals("application/x-pdf" )){
            try {
                InputStream file = FileDownloadHelper.downloadBinary(this, uri);
                PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
                pdfView.fromStream(file);
            }
            catch (Exception e) {
                Toast.makeText(this, "@string/document_viewer_error", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
        else if ( mimeType.equals("image/jpeg")){
            try {
                InputStream file = FileDownloadHelper.downloadBinary(this, uri);
                ImageView imageView = (ImageView) findViewById(R.id.jpgView);
                imageView.setImageBitmap(BitmapFactory.decodeStream(file));
            } catch (Exception e) {
                Toast.makeText(this, "@string/document_viewer_error", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
        else {
            Toast.makeText(this, "@string/document_viewer_invalid", Toast.LENGTH_SHORT).show();
            this.finish();
        }

    }

}
