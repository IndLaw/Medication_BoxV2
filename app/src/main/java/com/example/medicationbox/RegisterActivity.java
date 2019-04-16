package com.example.medicationbox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.util.Log;

import com.example.medicationbox.helper.Functions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends AppCompatActivity {

    private Button mCreate;
    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    private User user;
    private FireDatabase storage;
    private Button btnRegister, btnLinkToLogin;
    private ProgressDialog pDialog;


    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnLinkToLogin = findViewById(R.id.btnLinkToLoginScreen);
        btnRegister = findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://medication-box.firebaseio.com");
        storage = new FireDatabase();

        // Link to Register Screen
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        mCreate = findViewById(R.id.btnRegister);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCreate.setBackgroundColor(getResources().getColor(R.color.red));

                mEmail = findViewById(R.id.rEditEmail);
                mPassword = findViewById(R.id.rEditPassword);
                EditText mName = findViewById(R.id.rName);


                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String name = mName.getText().toString();


                // Check for empty data in the form
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    if (Functions.isValidEmailAddress(email)) {
                        //the register user function would go here
                        createAccount(name, email, password);
                    } else {
                        Toast.makeText(getApplicationContext(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your details!", Toast.LENGTH_LONG).show();
                }

                Log.e("EMAIL", "User email is " + email);
                Log.e("PASSWORD", "User password is " + password);

                sendConf(email, password);
            }
        });
    }


    public void createAccount(String name, String email, String password)
    {
        final String tEmail = email;
        final String tPassword = password;
        final String tName = name;
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e("login", "createUserWithEmail:success");
                            FirebaseUser fireUser = FirebaseAuth.getInstance().getCurrentUser();

                            if (fireUser != null) {
                                String uid = fireUser.getUid();
                                //
                                user = new User(tName, tEmail, tPassword, uid);
                                storage.addUser(user, tEmail);

                                User eyyy = storage.retrieveUser(tEmail);
                                Log.e("Retrieved name", "Retrieved name: " + eyyy.getName());
                            }

                        }
                    }
                });
    }

    public void sendConf (final String email, final String password) {
        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setTitle("Send Email");
        progressDialog.show();
        Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GMailSender gMailSender = new GMailSender("mederx@gmail.com", "1530group");
                    gMailSender.sendMail("MedEx", "Hello!\n\nThank you for choosing MedEx!\n\nThe MedEx Team",
                            "mederx@gmail.com", email);
                    progressDialog.dismiss();
                } catch (Exception excep) {
                    Log.e("error_log", "Error: " + excep.getMessage());
                }
            }
        });
        send.start();
    }


}