package com.example.jessica.comelancav1;

import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MinhaTask extends AsyncTask<Object, Object, String> {

    private ProgressBar progressBar;
    private TextView texto;
    String[] status = {"Aceito pelo restaurante", "Em preparo", "Saiu para entrega", "Entrega realizada"};

    private int total = 0;
    private static int PROGRESSO = 25;

    public MinhaTask(Context context, ProgressBar progressBar, TextView texto) {
        this.progressBar = progressBar;
        this.texto = texto;
    }

   /* protected void onPreExecute() {
        texto.setText(status[0]);
        super.onPreExecute();
    }*/

    @Override
    protected String doInBackground(Object... params) {
        try {

            Thread.sleep(1500);

            for (int i=0; i<4; i++) {
                publishProgress();
                Thread.sleep(1500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Object... values) {

        total += PROGRESSO;
        int i = (total/25) - 1;
        progressBar.incrementProgressBy(PROGRESSO);
        texto.setText(status[i]);
        texto.setGravity(Gravity.CENTER_HORIZONTAL);
        super.onProgressUpdate(values);
    }

   /* @Override
    protected void onPostExecute(String result) {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        super.onPostExecute(result);
    }*/
}
