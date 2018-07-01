package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.jessica.comelancav1.domain.Util;
import com.example.jessica.comelancav1.domain.ZipCodeListener;

public class MainActivity extends AppCompatActivity {
    private static EditText etZipCode;
    private static String cep;
    private Util util;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("ComeLança");

        etZipCode = (EditText) findViewById(R.id.textCep);


    }
    public void openAddressActivity(View view) {
        Intent intent = new Intent(this, AddressActivity.class);
        intent.putExtra("CEP", etZipCode.getText().toString());
        startActivity(intent);
    }

    public void openSignUpActivity(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void openLoginActivity(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void validateCEP(View view){
        etZipCode.setError(null);
        String cep = etZipCode.getText().toString();

        if(cep.length() != 8){
            etZipCode.setError("Cep inválido");
            etZipCode.requestFocus();
        }else{
            openAddressActivity(view);
        }

    }
}
