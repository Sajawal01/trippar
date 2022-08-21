package com.example.trippar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ResetPassword extends AppCompatActivity {

    private EditText text1;
    private Button btnlink;
    private ImageButton btnback;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        text1 = findViewById(R.id.edit_email_reset_pass);
        btnlink = findViewById(R.id.send_link_btn);
        btnback = findViewById(R.id.back_arrow_btn);

        firebaseAuth = FirebaseAuth.getInstance();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetPassword.this, LoginActivity.class));
                finish();
            }
        });

        btnlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = text1.getText().toString().trim();

                sendLink(email);


                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(ResetPassword.this, LoginActivity.class));
                        finish();
                    }
                }, 2000);





            }
        });




    }

    private void sendLink(String email){



        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){

                    Toast.makeText(ResetPassword.this, "Reset Password link send to your email", Toast.LENGTH_SHORT).show();





                }else{

                    Toast.makeText(ResetPassword.this, ""+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ResetPassword.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    }
