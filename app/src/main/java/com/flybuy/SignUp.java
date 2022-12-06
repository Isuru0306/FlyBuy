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

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button registerCus = findViewById(R.id.register);
        TextView log =findViewById(R.id.btnLogin);
        EditText username = findViewById(R.id.username);
        EditText mobileNo = findViewById(R.id.mobileNo);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText cpassword = findViewById(R.id.confirmpass);


        FlyBuy flyBuy = new FlyBuy(SignUp.this);

        registerCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = username.getText().toString();
                String mNo = mobileNo.getText().toString();
                String eMali = email.getText().toString();
                String pwd = password.getText().toString();
                String cpwd = cpassword.getText().toString();

                if (uName.isEmpty() && mNo.isEmpty() && eMali.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SignUp.this, "All fields required..!", Toast.LENGTH_SHORT).show();
                }else{

                    if (pwd.equals(cpwd)){
                        flyBuy.addNewUser(uName, mNo, eMali, pwd);
                        Toast.makeText(SignUp.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        mobileNo.setText("");
                        email.setText("");
                        password.setText("");
                    }else{
                        Toast.makeText(SignUp.this, "Confirm password not match", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(SignUp.this, Login.class);
                startActivity(i);
            }
        });

    }
}