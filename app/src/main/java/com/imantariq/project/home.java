package com.imantariq.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class home extends AppCompatActivity {

    ImageView left;
    TextView mealplan;
    DrawerLayout drwr;
    TextView shoplist,profile,editpass,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        left=findViewById(R.id.left);
        drwr=findViewById(R.id.drwr);
        mealplan=findViewById(R.id.mealplanbt);
        shoplist=findViewById(R.id.shoplist);
        profile=findViewById(R.id.profile);
        editpass=findViewById(R.id.editpass);
        exit=findViewById(R.id.exittext);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home.this,login.class);
                startActivity(i);
            }
        });

        editpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home.this,forgetpass.class);
                startActivity(i);
            }
        });

        shoplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home.this,shopping.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home.this,profile.class);
                startActivity(i);
            }
        });

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


        mealplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(home.this,mealplans.class);
                startActivity(i);

            }
        });
    }
}