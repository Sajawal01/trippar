package com.example.trippar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivty extends AppCompatActivity {

    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);

        utils = new Utils(this);
        delay();
    }

    private void delay(){
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(utils.isLoggedIn()){
                    Intent intent = new Intent(SplashActivty.this, TestActivty.class);
                    startActivity(intent);
                }

                else{
                    Intent intent = new Intent(SplashActivty.this,LoginActivity.class);
                    startActivity(intent);
                }
                finish();

            }
        },3000);
    }
}