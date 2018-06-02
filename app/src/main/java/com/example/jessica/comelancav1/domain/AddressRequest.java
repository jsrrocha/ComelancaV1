package com.example.jessica.comelancav1.domain;

import android.os.AsyncTask;
import android.widget.EditText;

import com.example.jessica.comelancav1.MainActivity;
import com.example.jessica.comelancav1.R;
import com.google.gson.Gson;

import java.lang.ref.WeakReference;

import com.example.jessica.comelancav1.AddressActivity;


public class AddressRequest extends AsyncTask<Void, Void, Address> {
    private WeakReference<AddressActivity> activity;

    public AddressRequest(AddressActivity activity ){
        this.activity = new WeakReference<>( activity );
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if( activity.get() != null ){
            activity.get().lockFields( true );
        }
    }

    @Override
    protected Address doInBackground(Void... voids) {
        try {
            String jsonString = JsonRequest.request( AddressActivity.getUriZipCode() );
            Gson gson = new Gson();
            return gson.fromJson( jsonString, Address.class );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Address address) {
        super.onPostExecute(address);

        if( activity.get() != null ){
            activity.get().lockFields( false );

            if( address != null ){
                activity.get().setDataViews( address );
            }
        }
    }
}
