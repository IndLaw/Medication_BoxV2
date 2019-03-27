package com.example.medicationbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FireBase {

    private FirebaseAuth mAuth;
    private DatabaseReference mReference;

    Context context;

    private User user;

    public FireBase()
    {
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://medication-box.firebaseio.com");

    }

    public void RegisterActivity(Context context){
        this.context = context;
    }

    public void createAccount(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("login", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("login", "createUserWithEmail:failure", task.getException());

                        }
                    }
                });
    }

    public void signIn(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("signedin", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w("signedin", "signInWithEmail:failure", task.getException());
                            Toast.makeText( context, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    public void getUser()
    {

    }

}
