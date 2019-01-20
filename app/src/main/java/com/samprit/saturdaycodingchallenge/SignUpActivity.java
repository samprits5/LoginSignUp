package com.samprit.saturdaycodingchallenge;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private AutoCompleteTextView nameView, emailView;
    private EditText passView, conPassView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nameView = findViewById(R.id.name);
        emailView = findViewById(R.id.signUpEmail);
        passView = findViewById(R.id.signUpPassword);
        conPassView = findViewById(R.id.conPassword);

    }

    public void signUpClick(View view){

        boolean empty = false;
        boolean error = false;

        if (TextUtils.isEmpty(nameView.getText())){
            nameView.setError("Don't leave it blank!");
            empty = true;
            error = true;
        }
        if (TextUtils.isEmpty(emailView.getText())){
            emailView.setError("Don't leave it blank!");
            empty = true;
            error = true;
        }
        if (TextUtils.isEmpty(passView.getText())){
            passView.setError("Don't leave it blank!");
            empty = true;
            error = true;
        }
        if (TextUtils.isEmpty(conPassView.getText())){
            conPassView.setError("Don't leave it blank!");
            empty = true;
            error = true;
        }

        if (!empty){

            if (!validateEmail(emailView.getText().toString())){
                emailView.setError("Enter a valid email!");
                error = true;
            }

            if (passView.getText().toString().length() < 5){
                passView.setError("Password too small!");
                error = true;
            }

            if (conPassView.getText().toString().length() < 5){
                conPassView.setError("Password too small!");
                error = true;
            }

            if (!passView.getText().toString().equals(conPassView.getText().toString())){
                conPassView.setError("Password doesn't match!");
                error = true;
            }

        }
        if (!error) {
            progressDialog();
        }


    }

    private boolean validateEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.matches(emailPattern)){
            return true;
        } else {
            return false;
        }
    }

    private void progressDialog(){
        final ProgressDialog pd = new ProgressDialog(SignUpActivity.this);
        pd.setMessage("Signing up...");
        pd.show();
        new CountDownTimer(5000, 5000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                pd.dismiss();
                Toast.makeText(SignUpActivity.this, "Dummy Sign Up Successful!", Toast.LENGTH_SHORT).show();
            }

        }.start();
    }
}
