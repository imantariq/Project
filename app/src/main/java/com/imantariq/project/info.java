package com.imantariq.project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class info extends AppCompatActivity {
    Button b;
    String value,valueh;
    EditText height,weight,goalweight,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        age=findViewById(R.id.age);
        goalweight=findViewById(R.id.goalweight);

         Spinner spinner=findViewById(R.id.spin);
         Spinner spinner1=findViewById(R.id.spin1);

        String[] unitsw={ "kg" , "pounds"};
        String[] unitsh={"feet","cm"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(info.this , android.R.layout.simple_spinner_item,unitsw);

        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(info.this , android.R.layout.simple_spinner_item,unitsh);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                value=parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {



            }
            });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueh=parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {



            }
        });

        b = findViewById(R.id.pref);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> user = new HashMap<>();
                user.put("weight", weight.getText().toString()+value);
                user.put("height", height.getText().toString()+valueh);
                user.put("age", age.getText().toString());
                user.put("goalweight", goalweight.getText().toString());

                db.collection("users")
                        .document(Objects.requireNonNull(auth.getUid())).
                        set(user, SetOptions.merge());
                Intent intent = new Intent(info.this, pref.class);
                startActivity(intent);

            }
        });
    }
}
