package com.mit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    SharedPreferences preferences ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        preferences = getApplicationContext().getSharedPreferences("MySharedPrefs",MODE_PRIVATE);


        String username = preferences.getString("username",null);//getIntent().getStringExtra("username");
        TextView txtUserWelcome = findViewById(R.id.txtUserWelcome);
        txtUserWelcome.setText("Hello "+username);

        if (username==null){

            Toast.makeText(this,"Kindly login first",Toast.LENGTH_SHORT).show();
            //user logged
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }


        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                startActivity(new Intent(DashBoardActivity.this,MainActivity.class));
                finish();//function we use kill the current activity

            }
        });
    }
}