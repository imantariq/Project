package com.imantariq.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class mealplans extends AppCompatActivity {

    CardView cv;
    ImageView left;
    DrawerLayout drwr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealplans);
        cv=findViewById(R.id.meal1);
        left=findViewById(R.id.left);
        drwr=findViewById(R.id.drwr);


        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drwr.isDrawerOpen(Gravity.LEFT))
                {
                    drwr.closeDrawer(Gravity.LEFT);
                }
                else
                {
                    drwr.openDrawer(Gravity.LEFT);
                }

            }
        });

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mealplans.this,planner.class);
                startActivity(i);
            }
        });
    }
}