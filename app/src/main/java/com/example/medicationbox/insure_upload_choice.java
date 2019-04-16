package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class insure_upload_choice extends Activity {
    private Button toTheInsurePic;
    private Button toTheInsureManual;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insure_upload_choice);
        Button home = findViewById(R.id.InsureUploadChoiceHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(insure_upload_choice.this, Homepage.class);
                startActivity(i);
            }
        });

        toTheInsurePic = findViewById(R.id.toinsurancecard);
        toTheInsureManual = findViewById(R.id.toperscription);

        toTheInsureManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toperscrip = new Intent(insure_upload_choice.this, InsuranceView.class);
                startActivity(toperscrip);
            }
        });
    }

}
