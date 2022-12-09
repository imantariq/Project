package com.imantariq.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class pref extends AppCompatActivity {
    TextView textView,tv2;
    Button b;
    boolean[] selected;
    boolean[] avoid;
    ArrayList<Integer> langList = new ArrayList<>();
    ArrayList<Integer> avoidList = new ArrayList<>();
    EditText other;

    String[] langArray = {"Vegetarian", "Vegan", "Gluten-Free", "Low-Carb", "Healthy","High-Protein"};

    String[] avoidArray = {"Coriander","Peanuts","Mint","Eggs","Fish","ShellFish","Wheat","Alcohol"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        b = findViewById(R.id.done);
        tv2=findViewById(R.id.textView1);
        other=findViewById(R.id.other);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> user = new HashMap<>();
                String pref="";
                String avoid="";

                for(int i=0;i<langList.size();i++)
                {
                    pref+=langArray[langList.get(i)]+", ";
                }


                for(int i=0;i<avoidList.size();i++)
                {
                    avoid+=avoidArray[avoidList.get(i)]+", ";
                }

                user.put("Dietary Preferences", pref);
                user.put("Avoid Ingredients", avoid);
                user.put("Other",other.getText().toString());

                db.collection("users")
                        .document(Objects.requireNonNull(auth.getUid())).
                        set(user, SetOptions.merge());
                Intent intent=new Intent(pref.this,home.class);
                startActivity(intent);
            }
        });
        // assign variable
        textView = findViewById(R.id.textView);

        // initialize selected language array
        selected = new boolean[langArray.length];

        avoid=new boolean[avoidArray.length];

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(pref.this);

                // set title
                builder.setTitle("Select Dietary Patterns");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(langArray, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            langList.add(i);
                            // Sort array list
                            Collections.sort(langList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            langList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < langList.size(); j++) {
                            // concat array value
                            stringBuilder.append(langArray[langList.get(j)]);
                            // check condition
                            if (j != langList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        textView.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selected.length; j++) {
                            // remove all selection
                            selected[j] = false;
                            // clear language list
                            langList.clear();
                            // clear text view value
                            textView.setText("");
                        }
                    }
                });
                // show dialog
                builder.show();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(pref.this);

                // set title
                builder.setTitle("Select Ingredients to avoid");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(avoidArray, avoid, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            avoidList.add(i);
                            // Sort array list
                            Collections.sort(avoidList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            avoidList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < avoidList.size(); j++) {
                            // concat array value
                            stringBuilder.append(avoidArray[avoidList.get(j)]);
                            // check condition
                            if (j != avoidList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        tv2.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < avoid.length; j++) {
                            // remove all selection
                            avoid[j] = false;
                            // clear language list
                            avoidList.clear();
                            // clear text view value
                            tv2.setText("");
                        }
                    }
                });
                // show dialog
                builder.show();
            }
        });





    }
}
