package com.example.medicationbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;
import com.google.firebase.*;


public class RegisterActivity extends AppCompatActivity {

    private Button mCreate;
    private EditText mEmail;
    private EditText mPassword;
    // private User user;

    private FireBase mFirebase;

    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebase = new FireBase();

        mCreate = (Button) findViewById(R.id.next_button);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = (EditText) findViewById(R.id.email_editText);
                mPassword = (EditText) findViewById(R.id.password_editText);

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();


                Log.e("EMAIL", "User email is " + email);
                Log.e("PASSWORD", "User password is " + password);

                mFirebase.createAccount(email, password);

            }
        });

    }
}