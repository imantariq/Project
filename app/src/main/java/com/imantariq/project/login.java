package com.imantariq.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    Button b;
    TextView tv;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = findViewById(R.id.login);
        tv=findViewById(R.id.fp);
        r=findViewById(R.id.reg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,home.class);
                startActivity(intent);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,forgetpass.class);
                startActivity(intent);
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,register.class);
                startActivity(intent);
            }
        });
    }
}