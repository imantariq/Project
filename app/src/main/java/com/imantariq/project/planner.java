package com.imantariq.project;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class planner extends AppCompatActivity {
    Button savebut;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);
        savebut=findViewById(R.id.savebut);

        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(planner.this,mealplans.class);
                startActivity(i);
            }
        });

    }


}