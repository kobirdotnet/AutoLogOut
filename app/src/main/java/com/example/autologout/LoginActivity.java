package com.example.autologout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText userName,password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName =  findViewById(R.id.username_field);
        password =  findViewById(R.id.pass_field);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().trim().equals("")) {
                    Toast.makeText(LoginActivity.this, "Please input your user name", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().trim().equals("")) {
                    Toast.makeText(LoginActivity.this, "Please input your password", Toast.LENGTH_SHORT).show();
                } else if (userName.getText().toString().equals("hello") &&
                        password.getText().toString().equals("admin")) {
                    //Correct user name and password, go to main screen
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong input data", Toast.LENGTH_SHORT).show();
                }

                    View view = getCurrentFocus();
                    if (view != null){
                        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
                    }
            }
        });

//        hideKeyboard();
    }

//    private void hideKeyboard() {
//        View view = getCurrentFocus();
//        if (view != null){
//            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
//        }
//    }
}
