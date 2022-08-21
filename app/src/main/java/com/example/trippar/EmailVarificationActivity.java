package com.example.trippar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.trippar.ui.SettingsFragment.SettingsFragment;
import com.example.trippar.ui.home.HomeFragment;

import com.example.trippar.ui.weather.WeatherFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailVarificationActivity extends AppCompatActivity {

    private static final String TAG = EmailVarificationActivity.class.getSimpleName();

    private Button sendVerifyLink, verifyEmail, logoutBtn;
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_varification);

        sendVerifyLink = findViewById(R.id.send_verification_link);
        verifyEmail = findViewById(R.id.verify_btn);
        logoutBtn = findViewById(R.id.logout_btn_email_verification);

        mAuth = FirebaseAuth.getInstance();

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);


        if(mAuth.getCurrentUser().isEmailVerified()){

            mAuth.getCurrentUser().reload();
            Intent intent = new Intent(EmailVarificationActivity.this, TestActivty.class);
            startActivity(intent);
            finish();

        }


        sendVerifyLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                if(!mAuth.getCurrentUser().isEmailVerified()){
                    mAuth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.d(TAG, "onSuccess: email sent");
                            dialog.dismiss();
                            Toast.makeText(EmailVarificationActivity.this, "We have send the link to your registered email address please check it", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            dialog.dismiss();
                            Toast.makeText(EmailVarificationActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });


        verifyEmail.setOnClickListener(view -> {

            dialog.show();
            mAuth = FirebaseAuth.getInstance();
            mAuth.getCurrentUser().reload();

            if (!mAuth.getCurrentUser().isEmailVerified()) {
                mAuth.getCurrentUser().reload();

                if (mAuth.getCurrentUser().isEmailVerified()) {

                    Toast.makeText(EmailVarificationActivity.this, "Your Email is verified now", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmailVarificationActivity.this, TestActivty.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                    dialog.dismiss();
                    finish();

                } else {
                    dialog.dismiss();
//                    Toast.makeText(EmailVarificationActivity.this, "Email not Verified", Toast.LENGTH_SHORT).show();
                }

            } else {
                dialog.dismiss();
                Toast.makeText(EmailVarificationActivity.this, "Your Email is verified now", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EmailVarificationActivity.this, TestActivty.class));

                finish();
            }


        });


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Toast.makeText(EmailVarificationActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EmailVarificationActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        mAuth.getCurrentUser().reload();

        if(mAuth.getCurrentUser().isEmailVerified()){

            startActivity(new Intent(EmailVarificationActivity.this, HomeFragment.class));
            finish();

        }
    }

    @Override
    protected void onStart() {
        super.onStart();


        mAuth.getCurrentUser().reload();
        if(mAuth.getCurrentUser().isEmailVerified()){

            startActivity(new Intent(EmailVarificationActivity.this, HomeFragment.class));
            finish();

        }
    }

}