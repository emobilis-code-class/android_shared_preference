package com.mit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        final String username="demo";
        final String password="demo1234";

        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        Button btnLogin  = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().isEmpty()){
                    edtUsername.setError("Provide a username");
                }else{
                    if (edtPassword.getText().toString().isEmpty()){
                        edtPassword.setError("Provide your password");
                    }else{

                        ///everything
                        //- check if the password and user
                        if (edtUsername.getText().toString().equals(username) && edtPassword.getText().toString().equals(password)){
                            //login succcessfull
                            //- take the user to dashboard
                            Intent intent = new Intent(context,DashBoardActivity.class);
                            //intent.putExtra("username",edtUsername.getText().toString());
                            startActivity(intent);

                            //Shared Preference
                            //Object
                            SharedPreferences preferences = getApplicationContext().getSharedPreferences("MySharedPrefs",MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("username",edtUsername.getText().toString());
                            editor.apply();

                        }else{
                            //
                            Toast.makeText(context,"Invalid password or username.Kindly try again",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });

    }
}