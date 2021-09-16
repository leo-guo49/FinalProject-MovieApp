package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText username, password, repassword, maill;
    Button regist;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);
        maill = (EditText)findViewById(R.id.mail);
        regist = (Button) findViewById(R.id.register);
        DB = new DBHelper(this);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String email = maill.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||email.equals(""))
                    Toast.makeText(signup.this, "plz enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(email);
                        if(checkuser == false){
                            Boolean insert = DB.insertData(email, pass);
                            if(insert == true){
                                Toast.makeText(signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(signup.this, "Registered failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(signup.this, "mail already exsit", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(signup.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
