package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PaymentOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);



        RadioGroup radioGroupTroco = (RadioGroup) findViewById(R.id.Troco);
        radioGroupTroco.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                String option = rb.getText().toString();

                EditText input = findViewById(R.id.editTextTroco);
                if(option.equals("Sim")){
                    input.setVisibility(View.VISIBLE);
                }else{
                    input.setVisibility(View.INVISIBLE);
                }
            }
        });

        RadioGroup radioGroupCPF = (RadioGroup) findViewById(R.id.CPF);
        radioGroupCPF.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                String option = rb.getText().toString();

                EditText input = findViewById(R.id.editTextCpf);
                if(option.equals("Sim")){
                    input.setVisibility(View.VISIBLE);
                }else{
                    input.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    public void openStatusActivity(View view) {
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);
    }

    public void openListActivity(View view) {
        Intent intent = new Intent(this, ListRestaurantActivity.class);
        startActivity(intent);
    }

    public void onClickOptions(View view){

        final RadioGroup group = findViewById(R.id.Troco);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) group.findViewById(checkedId);
                String option = button.getText().toString();

                if(option == "Sim"){
                    EditText input = findViewById(R.id.editTextTroco);
                    input.setVisibility(View.VISIBLE);
                }

            }
        });
    }



}
