package br.com.futeboldospais.futeboldospais.dao;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Daniel Almeida on 22/10/2017.
 * Classe que grava e lê dados da memória interna do dispositivo
 * Tem nada a ver com DAO, só coloquei esse nome pra ficar parecida com as outras
 */

public class DistintivoDAO {

    /**
     * Método utilizado para salvar uma imagem bitmap no formato .png na pasta da aplicação
     * na mémoria interna do dispositivo
     * @param b Imagem bitmap a ser gravada
     * @param context Contexto da aplicação
     * @param nome Nome da imagem que será gravada
     * @return
     */
    public void salvarImagemNoArmazenamentoInterno(Bitmap b, Context context, String nome){
        Log.d("teste", "fui chamado salvar");

        ContextWrapper contextWrapper = new ContextWrapper(context);
        //Caminho para /data/data/yourapp/app_data/imageDir

        String nomeDiretorio = "distintivos"; //Nome da pasta no diretório android/data/
        File diretorio = contextWrapper.getDir(nomeDiretorio, Context.MODE_PRIVATE);

        //Cria o diretório e define o nome do arquivo
        File caminhoCompleto = new File(diretorio,nome);

        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream(caminhoCompleto);
            //Compressa o bitmap para escrever no formato imagem no FileOutputStream
            b.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("teste", "" + diretorio.getAbsolutePath() + " " + caminhoCompleto.getAbsolutePath());
    }

    /**
     * Método para carregar a imagem armazenada na memória interna
     * @param diretorio Caminho do diretório onde está a imagem
     * @param nome Nome da imagem
     * @return
     */
    public Bitmap carregarImagemDoArmazenamentoInterno(String diretorio, String nome) {
        Log.d("teste", "fui chamado mostrar");
        Bitmap b;

        try {
            File file = new File(diretorio, nome);
            b = BitmapFactory.decodeStream(new FileInputStream(file));
            return b;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Método utilizado para excluir uma imagem salva na memória interna
     * @param diretorio Caminho do diretório onde está a imagem
     * @param nome Nome da imagem
     * @return Se a imagem foi deletada ou não (true or false)
     */
    public boolean excluirImagemNoArmazenamentoInterno(String diretorio, String nome){
        Log.d("teste", "fui chamado deletar");
        File file = new File(diretorio, nome);
        boolean deletado = file.delete();
        return deletado;
    }
}
