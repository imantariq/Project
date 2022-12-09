package com.imantariq.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class register extends AppCompatActivity {
    Button button;
    EditText name,email,newpass,confirmpass;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        button = findViewById(R.id.next);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        newpass=findViewById(R.id.newpass);
        confirmpass=findViewById(R.id.confirmpass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  //              if (confirmpass.getText().toString() != newpass.getText().toString()) {
//                    Toast.makeText(register.this, "Passwords do not match", Toast.LENGTH_LONG).show();

              //  }

                    pass=confirmpass.getText().toString();
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(email.getText().toString().trim(), pass.trim())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(register.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                FirebaseFirestore db = FirebaseFirestore.getInstance();
                                Map<String, Object> user = new HashMap<>();
                                user.put("Name", name.getText().toString());
                                user.put("Email", email.getText().toString());
                                user.put("Password", pass);

                                db.collection("users")
                                        .document(Objects.requireNonNull(auth.getUid())).
                                        set(user, SetOptions.merge());

                                Intent intent = new Intent(register.this, info.class);
                                startActivity(intent);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(register.this, e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });



            }
        });


    }
}