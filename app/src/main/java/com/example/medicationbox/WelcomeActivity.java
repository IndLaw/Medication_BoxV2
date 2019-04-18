package com.example.medicationbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {
    private static int WELCOME_TIME_OUT = 5000;

        Handler handler;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.welcome_activity);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent homeIntent=new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            },WELCOME_TIME_OUT);
    }
}
