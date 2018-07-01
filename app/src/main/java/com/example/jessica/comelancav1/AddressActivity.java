package com.example.jessica.comelancav1;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jessica.comelancav1.domain.Address;
import com.example.jessica.comelancav1.domain.AddressRequest;
import com.example.jessica.comelancav1.domain.Util;
import com.example.jessica.comelancav1.domain.ZipCodeListener;


public class AddressActivity extends AppCompatActivity {
    private static String etZipCode;
    private Util util;
    private Context context;

    //ui elements
    private EditText mNumView;
    private EditText mCompView;
    private EditText mBairroView;
    private EditText mAddressView;
    private EditText mCityView;
    private Spinner mSpinnerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        etZipCode = getIntent().getStringExtra("CEP");


        Spinner spStates = (Spinner) findViewById(R.id.spinnerState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this,
                        R.array.states,
                        android.R.layout.simple_spinner_item);
        spStates.setAdapter(adapter);


        util = new Util(this,
                R.id.editTextCity,
                R.id.spinnerState,
                R.id.editTextAddress,
                R.id.editTextNum,
                R.id.editTextBairro,
                R.id.editTextComp);

        new AddressRequest(this).execute();

        // Set up the login form.
        mAddressView = (EditText) findViewById(R.id.editTextAddress);
        mNumView = (EditText) findViewById(R.id.editTextNum);
        mCityView = (EditText) findViewById(R.id.editTextCity) ;
        mCompView = (EditText) findViewById(R.id.editTextComp);
        mBairroView = (EditText) findViewById(R.id.editTextBairro);
        mSpinnerView = findViewById(R.id.spinnerState);

    }


    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openListRestaurantActivity(View view) {
        Intent intent = new Intent(this, ListRestaurantActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

      /*  if( requestCode == Address.REQUEST_ZIP_CODE_CODE
                && resultCode == RESULT_OK ){

            etZipCode.setText( data.getStringExtra( Address.ZIP_CODE_KEY ) );
        }*/
    }

    public static String getUriZipCode(){
        return "https://viacep.com.br/ws/"+etZipCode+"/json/";
    }


    public void lockFields( boolean isToLock ){
        util.lockFields( isToLock );
    }


    public void setField( int id, String data ){
        ((EditText) findViewById(id)).setText( data );
    }

    private void setSpinner( int id, int arrayId, String data ){
        String[] itens = getResources().getStringArray(arrayId);

        for( int i = 0; i < itens.length; i++ ){

            if( itens[i].endsWith( "("+data+")" ) ){
                ((Spinner) findViewById(id)).setSelection( i );
                return;
            }
        }
        ((Spinner) findViewById(id)).setSelection( 0 );
    }

    public void setDataViews(Address address){
        setField( R.id.editTextAddress, address.getLogradouro() );
        setField( R.id.editTextBairro, address.getBairro() );
        setField( R.id.editTextComp, address.getComplemento() );
        setField( R.id.editTextCity, address.getLocalidade() );
        setSpinner( R.id.spinnerState, R.array.states, address.getUf() );
    }


    public void attemptSearch(View view){
        mAddressView.setError(null);
        mNumView.setError(null);
        mCityView.setError(null);
        mCompView.setError(null);
        mBairroView.setError(null);

        String address = mAddressView.getText().toString();
        String num = mNumView.getText().toString();
        String city = mCityView.getText().toString();
        String comp = mCompView.getText().toString();
        String bairro = mBairroView.getText().toString();
        String estado = mSpinnerView.getSelectedItem().toString();
        boolean errorDetected = false;
        View focusView = null;

        if(bairro.isEmpty()){
            mBairroView.setError("Campo obrigatório");
            errorDetected = true;
            focusView = mBairroView;
        }

        if(num.isEmpty()){
            mNumView.setError("Campo obrigatório");
            errorDetected = true;
            focusView = mNumView;
        }

        if(address.isEmpty()){
            mAddressView.setError("Campo obrigatório");
            errorDetected = true;
            focusView = mAddressView;
        }

        if(city.isEmpty()){
            mCityView.setError("Campo obrigatório");
            errorDetected = true;
            focusView = mCityView;
        }

        if(estado.equals("*Estado")){
            mSpinnerView.getSelectedView().setBackgroundColor(Color.RED);
            errorDetected = true;
            focusView = mSpinnerView;

        }
        if (errorDetected){
            focusView.requestFocus();
        } else{
            openListRestaurantActivity(view);
        }


    }

}
