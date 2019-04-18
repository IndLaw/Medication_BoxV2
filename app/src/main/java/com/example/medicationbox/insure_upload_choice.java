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

        toTheInsurePic = findViewById(R.id.toPicInsUpload);
        toTheInsureManual = findViewById(R.id.toManualInsUpload);

        toTheInsureManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toinsure = new Intent(insure_upload_choice.this, InsuranceView.class);
                startActivity(toinsure);
            }
        });

        toTheInsurePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toinsure = new Intent(insure_upload_choice.this, UploadImageActivity.class);
                toinsure.putExtra("From", "Insure");
                startActivity(toinsure);
            }
        });
    }

}
