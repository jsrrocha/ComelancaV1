package com.example.jessica.comelancav1;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

public class StatusActivity extends AppCompatActivity {

    String[] status = {"Aceito\npelo\nrestaurante", "Em\npreparo", "Saiu\npara\nentrega", "Entrega\nrealizada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        TextView textTime = (TextView) findViewById(R.id.textTime);
        TextView textTimeTo = (TextView) findViewById(R.id.textViewTimeTo);
        TextView textViewH = (TextView) findViewById(R.id.textViewHours);


        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(status);

        stateProgressBar.setForegroundColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        stateProgressBar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.darker_gray));

        stateProgressBar.setStateNumberForegroundColor(ContextCompat.getColor(this, android.R.color.white));
        stateProgressBar.setStateNumberBackgroundColor(ContextCompat.getColor(this, android.R.color.background_dark));

        stateProgressBar.setStateSize(40f);
        stateProgressBar.setStateNumberTextSize(20f);
        stateProgressBar.setStateLineThickness(10f);

        stateProgressBar.checkStateCompleted(true);

        stateProgressBar.enableAnimationToCurrentState(true);
        stateProgressBar.setAnimationStartDelay(2000);
        stateProgressBar.setAnimationDuration(3000);

        stateProgressBar.setDescriptionTopSpaceIncrementer(10f);
        stateProgressBar.setStateDescriptionSize(16f);

        stateProgressBar.setCurrentStateDescriptionColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
        stateProgressBar.setStateDescriptionColor(ContextCompat.getColor(this,  android.R.color.holo_green_dark));

        stateProgressBar.setStateDescriptionTypeface("fonts/RobotoSlab-Light.ttf");
        stateProgressBar.setStateNumberTypeface("fonts/Questrial-Regular.ttf");

        stateProgressBar.setMaxDescriptionLine(3);
        stateProgressBar.setJustifyMultilineDescription(false);
        stateProgressBar.setDescriptionLinesSpacing(10f);

        stateProgressBar.setStateNumberIsDescending(false);

        //ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
       // TextView texto = (TextView) findViewById(R.id.texto);

        new MyTask(this, stateProgressBar,textTimeTo,textTime,textViewH).execute();
    }
}
