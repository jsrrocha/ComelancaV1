package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    String text1 = "";
    String text2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView totalValue =  findViewById(R.id.textViewTotalValue);
        TextView subTotal =  findViewById(R.id.textViewSubValue);
        text1 = getIntent().getStringExtra("text1");
        text2 = getIntent().getStringExtra("text2");

        final ListView itens = (ListView) findViewById(R.id.itens);
        List<String> list = new ArrayList<String>();
        if (text1 != null && !text1.equals("")) {
            list.add(text1);
        }
        if (text2 != null && !text2.equals("")) {
            list.add(text2);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        itens.setAdapter(adapter);

        //some com os botões de quantidade do segundo item caso nao esteja marcado
        oneItem(text1,text2);
        Log.e("TAG","antes");
        //Calcula valores e altera na tela
        if(text1 != null && text2 != null) {
            Integer subQtd1 = 0;
            Integer subQtd2 = 0;
            if (text1 != null && !text1.equals("")) {
                TextView textQ1 = findViewById(R.id.textViewQtd1);
                String qtdString =  textQ1.getText().toString();
                subQtd1 = subHardcode(totalValue,subTotal,text1,qtdString);
            }
            if (text2 != null && !text2.equals("")) {
                TextView textQ2 = findViewById(R.id.textViewQtd1);
                String qtdString =  textQ2.getText().toString();
                subQtd2 = subHardcode(totalValue,subTotal,text2,qtdString);
            }

            Integer soma = subQtd1 + subQtd2;
            subTotal.setText(soma.toString());

            //soma do sub com a taxa de entrega(5 reais pra todos)
            Integer total = Integer.parseInt(subTotal.getText().toString()) + 5;
            totalValue.setText(total.toString());
        }
    }

    public Integer subHardcode(TextView totalValue,TextView subTotal,String text,String qtdString) {

        Integer sub = Integer.parseInt(subTotal.getText().toString());
        Integer qtd = Integer.parseInt(qtdString);
        Integer value = 0;
        if (text.equals("Xis salada")) {
            value = valueXis * qtd;
        } else if (text.equals("Dog salsicha")) {
            value = valueDog * qtd;
        } else if (text.equals("Prato vegetariano")) {
            value = valueVeg * qtd;
        } else if (text.equals("Salada mix")) {
            value = valueMix * qtd;
        } else if (text.equals("4 queijos(30 cm)")) {
            value = valueQueijo * qtd;
        } else if (text.equals("Frango com catupiry(30 cm)")) {
            value = valueFrango * qtd;
        } else {
            Log.e("ERROR ", "VALOR É 0");
        }

        return value;
    }


    public void increaseQuantity1(View view) {
        TextView totalValue =  findViewById(R.id.textViewTotalValue);
        TextView subTotal =  findViewById(R.id.textViewSubValue);
        TextView textQ1 = findViewById(R.id.textViewQtd1);
        String valueQtd1 =  textQ1.getText().toString();
        String valueQtd2 =  textQ1.getText().toString();

        try {
            Integer qtd1 =  Integer.parseInt(valueQtd1) + 1;
            textQ1.setText(qtd1.toString());

            Integer qtd2 =  Integer.parseInt(valueQtd2);
            Integer subQtd1 = subHardcode(totalValue,subTotal,text1,qtd1.toString());
            Integer subQtd2 = subHardcode(totalValue,subTotal,text2,qtd2.toString());

            Integer soma = subQtd1 + subQtd2;
            subTotal.setText(soma.toString());
            //soma do sub com a taxa de entrega(5 reais pra todos)
            Integer total = Integer.parseInt(subTotal.getText().toString()) + 5;
            totalValue.setText(total.toString());
        } catch (NumberFormatException e) {
            return ;
        }
    }

    public void decreaseQuantity1(View view) {
        TextView totalValue =  findViewById(R.id.textViewTotalValue);
        TextView subTotal =  findViewById(R.id.textViewSubValue);
        TextView textQ1 = findViewById(R.id.textViewQtd1);
        String valueQtd1 =  textQ1.getText().toString();
        String valueQtd2 =  textQ1.getText().toString();

        try {
            if(valueQtd1 != null && !valueQtd1.equals("") && !valueQtd1.equals("0")) {
                Integer qtd1 =  Integer.parseInt(valueQtd1) - 1;
                textQ1.setText(qtd1.toString());

                Integer qtd2 =  Integer.parseInt(valueQtd2);
                Integer subQtd1 = subHardcode(totalValue,subTotal,text1,qtd1.toString());
                Integer subQtd2 = subHardcode(totalValue,subTotal,text2,qtd2.toString());

                Integer soma = subQtd1 + subQtd2;
                subTotal.setText(soma.toString());
                //soma do sub com a taxa de entrega(5 reais pra todos)
                Integer total = Integer.parseInt(subTotal.getText().toString()) + 5;
                totalValue.setText(total.toString());
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

    public void oneItem(String tex1, String text2){
        if(text1.equals("") || text2.equals(""))  {
            ImageButton imInQ2 = findViewById(R.id.imageButtonIncQ2);
            ImageButton imDecQ2 = findViewById(R.id.imageButtonDecQ2);
            TextView textQ2 = findViewById(R.id.textViewQtd2);
            imInQ2.setVisibility(View.INVISIBLE);
            imDecQ2.setVisibility(View.INVISIBLE);
            textQ2.setVisibility(View.INVISIBLE);
        }
    }

    public void openPaymentOptionsActivity(View view) {
        Intent intent = new Intent(this, PaymentOptions.class);
        startActivity(intent);
    }



}
