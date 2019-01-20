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

public class CustomLoginActivity extends AppCompatActivity {

    private AutoCompleteTextView emailView;
    private EditText passView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        emailView = findViewById(R.id.email);
        passView = findViewById(R.id.password);


    }

    public void logInClick(View view){

        Boolean empty = false;

        Boolean error = false;

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
        if (!empty){
            String email = emailView.getText().toString().trim();
            if (!validateEmail(email)){
                emailView.setError("Enter a valid email!");
                error = true;
            }
            if (passView.getText().toString().length() < 5){
                passView.setError("Password too small!");
                error = true;
            }
        }
        if (!error){
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
        final ProgressDialog pd = new ProgressDialog(CustomLoginActivity.this);
        pd.setMessage("Logging in...");
        pd.show();
        new CountDownTimer(5000, 5000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                pd.dismiss();
                Toast.makeText(CustomLoginActivity.this, "Dummy Log In Successful!", Toast.LENGTH_SHORT).show();
            }

        }.start();
    }
}
