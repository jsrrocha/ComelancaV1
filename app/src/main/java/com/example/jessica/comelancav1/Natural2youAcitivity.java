package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

public class Natural2youAcitivity extends AppCompatActivity {
    RadioButton option1;
    RadioButton option2;
    String text1="";
    String text2="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural2you_acitivity);
    }

    public void openCartActivity(View view) {
        option1 =  findViewById(R.id.radioButtonVeg);
        option2 =  findViewById(R.id.radioButtonMix);

        if(option1.isChecked()){
            text1 = (String) option1.getText();
        }

        if(option2.isChecked()){
            text2 = (String) option2.getText();
        }

        if(!text1.equals("") && !text1.equals("")) {
            Intent intent = new Intent(this, CartActivity.class);
            intent.putExtra("text1", text1);
            intent.putExtra("text2", text2);
            startActivity(intent);
        }
    }
    public void openListRestaurantActivity(View view) {
        Intent intent = new Intent(this, ListRestaurantActivity.class);
        startActivity(intent);
    }


}