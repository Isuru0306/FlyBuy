package com.flybuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.flybuy.model.FlyBuy;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button log = findViewById(R.id.loginbtn);
        TextView loginL = findViewById(R.id.sinUp);

        EditText userName = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        FlyBuy flyBuy = new FlyBuy(Login.this);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Username and password required!", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<String> list = flyBuy.getUserData(userName.getText().toString());
                    if(list.isEmpty()){
                        Toast.makeText(Login.this, "Please register before logging in", Toast.LENGTH_SHORT).show();
                    }else{

                        if (list.get(0).equals(userName.getText().toString()) && list.get(3).equals(password.getText().toString())){
                            userName.setText("");
                            password.setText("");
                            Intent intentMain = new Intent(Login.this, MainActivity.class);
                            startActivity(intentMain);
                        }else{
                            Toast.makeText(Login.this, "Invalid user name or password.!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

            }
        });


        loginL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}