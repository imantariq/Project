package com.imantariq.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        b1 = findViewById(R.id.ep);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,pref.class);
                startActivity(intent);
            }
        });
        b2 = findViewById(R.id.ca);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profile.this,info.class);
                startActivity(intent);
            }
        });
    }
}