package com.imantariq.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class info extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Spinner spinner=findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.WeightUnit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        b = findViewById(R.id.pref);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(info.this,pref.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
        ((TextView) parent.getChildAt(1)).setTextColor(Color.WHITE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}