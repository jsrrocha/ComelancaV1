package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    Integer valueXis = 11;
    Integer valueDog = 9;
    Integer valueVeg = 23;
    Integer valueMix = 20;
    Integer valueQueijo = 32;
    Integer valueFrango = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView subTotal =  findViewById(R.id.textViewSubTotal);
        String text1 = getIntent().getStringExtra("text1");
        String text2 = getIntent().getStringExtra("text2");


        if(text2 == null || text2.equals("")){
             ImageButton imInQ2 = findViewById(R.id.imageButtonIncQ2);
             ImageButton imDecQ2 = findViewById(R.id.imageButtonDecQ2);
             TextView textQ2 = findViewById(R.id.textViewQtd2);
             imInQ2.setVisibility(View.INVISIBLE);
             imDecQ2.setVisibility(View.INVISIBLE);
             textQ2.setVisibility(View.INVISIBLE);
        }

        if(text1 != null && text2 != null) {
            final ListView itens = (ListView) findViewById(R.id.itens);
            List<String> list = new ArrayList<String>();
            if (text1 != null && !text1.equals("")) {
                list.add(text1);

                if(text1.equals("Xis Salada")){
                    subTotal.setText(valueXis.toString());
                }else if(text1.equals("Dog Salsicha")){
                    subTotal.setText(valueDog.toString());
                }else if(text1.equals("Prato vegetariano")){
                    subTotal.setText(valueVeg.toString());
                }else if(text1.equals("Salada mix")){
                    subTotal.setText(valueMix.toString());
                }else if(text1.equals("4 queijos(30 cm)")){
                    subTotal.setText(valueQueijo.toString());
                }else if(text1.equals("Frango com catupiry(30 cm)")){
                    subTotal.setText(valueFrango.toString());
                }
            }
            if (text2 != null && !text2.equals("")) {
                list.add(text2);
                Integer value = 0;
                Integer sub = Integer.parseInt(subTotal.getText().toString());
                if(text1.equals("Xis Salada")){
                    value = sub + valueXis;
                }else if(text1.equals("Dog Salsicha")){
                    value = sub + valueDog;
                }else if(text1.equals("Prato vegetariano")){
                    value = sub + valueDog;
                }else if(text1.equals("Salada mix")){
                    value = sub + valueMix;
                }else if(text1.equals("4 queijos(30 cm)")){
                    value = sub + valueQueijo;
                }else if(text1.equals("Frango com catupiry(30 cm)")){
                    value = sub + valueFrango;
                }
                subTotal.setText(value.toString());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, list);
            itens.setAdapter(adapter);
        }
    }

    public void openPaymentOptionsActivity(View view) {
        Intent intent = new Intent(this, PaymentOptions.class);
        startActivity(intent);
    }

    public void increaseQuantity1(View view) {
        TextView text = (TextView)findViewById(R.id.textViewQtd1);
        try {
            String value =  text.getText().toString();
            Integer qtd =  Integer.parseInt(value) + 1;
            text.setText(qtd.toString());
        } catch (NumberFormatException e) {
            return ;
        }
    }

    public void decreaseQuantity1(View view) {
        TextView text = (TextView)findViewById(R.id.textViewQtd1);
        String value =  text.getText().toString();
        try {
            if(value != null && !value.equals("") && value.equals("0")) {
                Integer qtd =  Integer.parseInt(value) - 1;
                text.setText(qtd.toString());
            }
        } catch (NumberFormatException e) {
                return ;
        }
    }

    public void increaseQuantity2(View view) {
        TextView text = (TextView)findViewById(R.id.textViewQtd2);
        try {
            String value =  text.getText().toString();
            Integer qtd =  Integer.parseInt(value) + 1;
            text.setText(qtd.toString());
        } catch (NumberFormatException e) {
            return ;
        }
    }

    public void decreaseQuantity2(View view) {
        TextView text = (TextView)findViewById(R.id.textViewQtd2);
        String value =  text.getText().toString();
        try {
            if(value != null && !value.equals("") && value.equals("0")) {
                Integer qtd =  Integer.parseInt(value) - 1;
                text.setText(qtd.toString());
            }
        } catch (NumberFormatException e) {
            return ;
        }
    }

    public void subTotal(){

    }

}
