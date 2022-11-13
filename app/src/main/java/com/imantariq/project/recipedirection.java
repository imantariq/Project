package com.imantariq.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class recipedirection extends AppCompatActivity {
    TextView tv;
    TextView nut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipedirection);
        tv=findViewById(R.id.ing);
        nut=findViewById(R.id.nut);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recipedirection.this,recipe.class);
                startActivity(intent);
            }
        });
        nut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(recipedirection.this,nutrit.class);
                startActivity(intent);
            }
        });

    }
}