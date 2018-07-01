package com.example.jessica.comelancav1;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

public class MyTask extends AsyncTask<Object, Object, String> {

    private StateProgressBar progressBar;
    private TextView textTimeTo;
    private TextView textTime;

    private TextView textViewH;
    private int total = 1;


    public MyTask(Context context, StateProgressBar progressBar,TextView textTimeTo,TextView textTime,TextView textViewH) {
        this.progressBar = progressBar;
        this.textTimeTo = textTimeTo;
        this.textTime = textTime;
        this.textViewH = textViewH;

    }

    @Override
    protected String doInBackground(Object... params) {
        try {
            //Thread.sleep(1500);
            for (int i=0; i<4; i++) {
                Thread.sleep(4000);
                total = total + 1;
                publishProgress();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Object... values) {

        switch (total) {
            case 2:
                 progressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                 textViewH.setText("Em preparo às 21:15");
                 textTime.setText("25 minutos");

                 break;
            case 3:
                 progressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                 textViewH.setText("Saiu para entrega às 21:40");
                 textTime.setText("15 minutos");
                 break;
            case 4:
                 progressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                 textViewH.setText("Boa refeição :)");
                 textTime.setText("");
                 textTimeTo.setText("");
                 break;
            default:
                 progressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
        }
        super.onProgressUpdate(values);
    }

}
