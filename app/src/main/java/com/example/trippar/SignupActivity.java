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
import android.widget.Toast;

import com.example.trippar.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confrim_password;
    private Button btn_back;
    private Button btn_signup;

    Dialog dialog;

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private Utils utils;
    private DocumentReference documentReference;

    private boolean isExist;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username_signup);
        email = findViewById(R.id.email_signup);
        password = findViewById(R.id.password_signup);
        confrim_password = findViewById(R.id.confirm_password_signup);
        btn_back = findViewById(R.id.btn_back_signup);
        btn_signup = findViewById(R.id.btn_signup);

        utils = new Utils(this);

        isExist = false;


        db = FirebaseFirestore.getInstance();
        utils = new Utils(this);
        mAuth = FirebaseAuth.getInstance();
        isExist = false;

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }

    private void validate() {

        if (username.getText().toString().isEmpty()) {
            username.setError("Username must contain value");
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Email must contain value");
        } else if (password.getText().toString().isEmpty()) {
            password.setError("Password must contain value");
        } else if (!confrim_password.getText().toString().equals(password.getText().toString())) {
            confrim_password.setError("Password cannot match");
        } else {
            dialog.show();
            createUser(email.getText().toString(),password.getText().toString());
        }
    }


//    This

//    private void authentication(String str_name, String str_email) {
//
//        final Lottiedialog lottie = new Lottiedialog(this);
//        lottie.show();
//
//        isExist = false;
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
//                                    isExist = true;
//                                    username.setError("User name is already exist");
//
//                                    lottie.dismiss();
//                                }
//                                else if (documentSnapshot.getString("email").equals(str_email)) {
//                                    isExist = true;
//                                    email.setError("Email is already exist");
//
//                                    lottie.dismiss();
//                                }
//                            }
//
//                            if (isExist == false) {
//                                documentReference = db.collection("student").document();
//
//                                String Username = username.getText().toString();
//                                String Email = email.getText().toString();
//                                String Password = password.getText().toString();
//
//
//                                Map<String, String> userMap = new HashMap<>();
//                                userMap.put("email", Email);
//                                userMap.put("user_name", Username);
//                                userMap.put("password", Password);
//                                userMap.put("document id", documentReference.getId());
//
//                                documentReference.set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                    @Override
//                                    public void onSuccess(Void unused) {
//
//                                        utils.putToken(documentReference.getId());
//                                        Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
//
//                                        Intent intent = new Intent(SignupActivity.this, HomeFragment.class);
//                                        startActivity(intent);
//                                        finish();
//
//                                    }
//                                }).addOnFailureListener(new OnFailureListener() {
//                                    @Override
//                                    public void onFailure(@NonNull Exception e) {
//
//                                        Toast.makeText(SignupActivity.this, "Signup Faild", Toast.LENGTH_SHORT).show();
//
//                                        lottie.dismiss();
//                                    }
//                                });
//
//                            }
//                        }
//                    }
//                });
//    }


//    This

    private void createUser(String email, String pass) {


        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    user = mAuth.getInstance().getCurrentUser();
                    String uid = user.getUid();

                    dataUpload(email, uid);


                } else {

                    dialog.dismiss();

                    Toast.makeText(SignupActivity.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                dialog.dismiss();

                Toast.makeText(SignupActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void dataUpload(String email, String uid) {


        String Username = username.getText().toString();


        Map<String, Object> userMap = new HashMap<>();
        userMap.put("Email", email);
        userMap.put("Username", Username);
        userMap.put("Document ID", uid);

        db.collection("student").document(uid).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    utils.putToken(uid);
                    dialog.dismiss();
                    Intent intent = new Intent(SignupActivity.this, EmailVarificationActivity.class);
                    startActivity(intent);
                    finish();

                } else {

                    dialog.dismiss();

                    Toast.makeText(SignupActivity.this, "Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(SignupActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}