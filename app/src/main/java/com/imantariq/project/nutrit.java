package com.imantariq.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class nutrit extends AppCompatActivity {
    TextView tv;
    TextView direc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrit);
        tv=findViewById(R.id.ing);
        direc=findViewById(R.id.dir);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(nutrit.this,recipe.class);
                startActivity(intent);
            }
        });
        direc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(nutrit.this,recipedirection.class);
                startActivity(intent);
            }
        });
    }

}