package com.example.jessica.comelancav1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    //UI references
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;
    private AutoCompleteTextView mNomeView;
    private AutoCompleteTextView mCPFView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        // Set up the login form.
        mNomeView = (AutoCompleteTextView) findViewById(R.id.nome);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mCPFView = (AutoCompleteTextView) findViewById(R.id.cpf) ;
        mPasswordView = (EditText) findViewById(R.id.senha);
        mConfirmPasswordView = (EditText) findViewById(R.id.senha2);

    }

    public void openMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void attemptSignUp(View view){

        mEmailView.setError(null);
        mPasswordView.setError(null);
        mConfirmPasswordView.setError(null);
        mNomeView.setError(null);
        mCPFView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String confirmPassword = mConfirmPasswordView.getText().toString();
        String Name = mNomeView.getText().toString();
        String CPF = mCPFView.getText().toString();

        View focusView = null;
        boolean errorDetected = false;

        if(!arePasswordsEqual(password, confirmPassword)){
            mConfirmPasswordView.setError("Senhas não são iguais");
            errorDetected = true;
            focusView = mConfirmPasswordView;
        }

        if(!isPasswordValid(password)){
            mPasswordView.setError("Senhas precisam conter mais que 4 caracteres");
            errorDetected = true;
            focusView = mPasswordView;
        }

        if(!isCPFValid(CPF)){
            mCPFView.setError("CPF inválido");
            errorDetected = true;
            focusView = mCPFView;
        }

        if (!isEmailValid(email)){
            mEmailView.setError("Email inválido");
            errorDetected = true;
            focusView = mEmailView;
        }

        if (!isNameValid(Name)){
            mNomeView.setError("Campo obrigatório");
            errorDetected = true;
            focusView = mNomeView;
        }

        if (errorDetected){
            focusView.requestFocus();
        } else{
            Intent intent = new Intent(this, AddressActivity.class);
            startActivity(intent);
        }

    }



    private boolean isEmailValid(String email) {

        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {

        return password.length() > 4;
    }

    private boolean arePasswordsEqual(String password, String confirmedPassword){
        return password.equals(confirmedPassword);
    }

    private boolean isCPFValid(String CPF){
        return CPF.length() == 11;
    }

    private boolean isNameValid(String Name){
        return !Name.isEmpty();
    }
}
