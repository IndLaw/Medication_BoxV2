package com.example.medicationbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DeletePmtActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState, final User usr) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletepayment);

        for(int i = 0; usr.pmt[i] != null; i++){
            //display payment methods with buttons
        }
    }
}
