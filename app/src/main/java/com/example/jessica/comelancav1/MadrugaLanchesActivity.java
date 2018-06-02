package com.example.jessica.comelancav1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MadrugaLanchesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madruga_lanches);
    }

    public void openPaymentOptionsActivity(View view) {
        Intent intent = new Intent(this, PaymentOptions.class);
        startActivity(intent);
    }

}
