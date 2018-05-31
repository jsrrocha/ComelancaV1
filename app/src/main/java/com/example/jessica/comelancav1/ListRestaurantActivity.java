package com.example.jessica.comelancav1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListRestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);
        ListView listaRestaurantes = (ListView)findViewById(R.id.lista);

        List<String> restaurantes = new ArrayList<String>();
        restaurantes.add("Restaurante 1");
        restaurantes.add("Restaurante 2");
        restaurantes.add("Restaurante 3");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, restaurantes);

        listaRestaurantes.setAdapter(adapter);
    }
}

