package com.example.medicationbox;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.medicationbox.helper.Functions;


import java.util.HashMap;
import java.util.Map;


public class RegisterActivityTemp extends AppCompatActivity {
    private static final String TAG = RegisterActivityTemp.class.getSimpleName();

    private Button btnRegister, btnLinkToLogin;
    private TextInputLayout inputName, inputEmail, inputPassword;
    private ProgressDialog pDialog;
    String name = "";
    String email = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName = (TextInputLayout) findViewById(R.id.rTextName);
        inputEmail = (TextInputLayout) findViewById(R.id.rTextEmail);
        inputPassword = (TextInputLayout) findViewById(R.id.rTextPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Hide Keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        init();
    }

    private void init() {
        // Login button Click Event
        btnRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                // Hide Keyboard
                Functions.hideSoftKeyboard(RegisterActivityTemp.this);

                String name = inputName.getEditText().getText().toString().trim();
                String email = inputEmail.getEditText().getText().toString().trim();
                String password = inputPassword.getEditText().getText().toString().trim();

                // Check for empty data in the form
                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    if (Functions.isValidEmailAddress(email)) {
                        //the register user function would go here
                        //registerUser(name, email, password); <-----------
                    } else {
                        Toast.makeText(getApplicationContext(), "Email is not valid!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your details!", Toast.LENGTH_LONG).show();
                }




            }

        });

        // Link to Register Screen
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(RegisterActivityTemp.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


    // Tag used to cancel the request
    //String tag_string_req = "req_register";

    //    pDialog.setMessage("Registering ...");
    //showDialog();

    // Adding request to request queue
    //    ApplicationTemp.getInstance().addToRequestQueue(strReq, tag_string_req);

    // Error occurred in registration. Get the error
    // message
    //String errorMsg = jObj.getString("message");
    //                    Toast.makeText(getApplicationContext(),errorMsg, Toast.LENGTH_LONG).show();

    protected Map<String, String> getParams() {
        // Posting params to register url
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);

        return params;
    }

    public void onErrorResponse(VolleyError error) {
        Log.e(TAG, "Registration Error: " + error.getMessage());
        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
        hideDialog();
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
