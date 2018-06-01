package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        final ListView listaRestaurantes = (ListView)findViewById(R.id.lista);

        List<String> restaurantes = new ArrayList<String>();
        restaurantes.add("Natural 2 you");
        restaurantes.add("Pizarria do Gatão");
        restaurantes.add("Madruga dos Lanches");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, restaurantes);

        listaRestaurantes.setAdapter(adapter);
        listaRestaurantes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent intent = new Intent(ListRestaurantActivity.this, Natural2youAcitivity.class);
                    startActivity(intent);
                }else if(position == 1) {
                    Intent intent = new Intent(ListRestaurantActivity.this, PizzariaGataoActivity.class);
                    startActivity(intent);
                }else if(position==2){
                    Intent intent = new Intent(ListRestaurantActivity.this, MadrugaLanchesActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

    public void openNatural2youAcitivity(View view) {
        Intent intent = new Intent(this, Natural2youAcitivity.class);
        startActivity(intent);
    }

    public void openPizzariaGataoActivity(View view) {
        Intent intent = new Intent(this, PizzariaGataoActivity.class);
        startActivity(intent);
    }
}

