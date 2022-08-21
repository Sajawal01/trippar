package com.example.trippar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btn_login;
    private TextView btn_creat;
    private TextView btn_forgot_pass;

    private FirebaseAuth mAuth;

    private Utils utils;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private boolean isIdExist;
    Dialog dialog;

    private DocumentReference documentReference;
    private boolean isExist;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.user_email_login);
        password = findViewById(R.id.password_login);
        btn_login = findViewById(R.id.btn_login);
        btn_creat = findViewById(R.id.btn_creat_login);
        btn_forgot_pass = findViewById(R.id.forgotpass_login);

        db = FirebaseFirestore.getInstance();
        utils = new Utils(this);
        mAuth = FirebaseAuth.getInstance();
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);



        btn_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ResetPassword.class);
                startActivity(intent);
                finish();
            }
        });


        btn_creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();

            }
        });
    }

    private void validate() {
        if (email.getText().toString().isEmpty()) {
            email.setError("Username must contain value");
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Password must contain value");
        } else {
            authentication(email.getText().toString(), password.getText().toString());

        }
    }

//    private void authentication(String str_name, String str_password) {
//
//        final Lottiedialog lottie = new Lottiedialog(this);
//        lottie.show();
//
//        db.collection("student")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
//                                if (documentSnapshot.getString("user_name").equals(str_name)) {
//
//                                    if (documentSnapshot.getString("password").equals(str_password)) {
//                                        String document_id_user = documentSnapshot.getString("document id");
//                                        utils.putToken(document_id_user);
//
//                                        lottie.dismiss();
//
//                                        Intent test = new Intent(LoginActivity.this, TestActivty.class);
//                                        startActivity(test);
//                                        finish();
//
//                                    } else {
//                                        password.setError("Password is invalid");
//
//                                        lottie.dismiss();
//                                    }
//                                }
//
//                            }
//                        } else {
//                            password.setError("Invalid username");
//
//                            lottie.dismiss();
//                        }
//                    }
//                });
//    }

    private void authentication(String email, String pass) {


        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    user = mAuth.getInstance().getCurrentUser();
                    String uid = user.getUid();

                    utils.putToken(uid);
                    dialog.dismiss();

                    startActivity(new Intent(LoginActivity.this, EmailVarificationActivity.class));
                    finish();


                } else {
                    dialog.dismiss();

                    Toast.makeText(LoginActivity.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(LoginActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}