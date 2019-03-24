package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DocumentView extends AppCompatActivity {

    private Button toTheInsuranceCard;
    private Button toThePerscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_choice);

        toTheInsuranceCard = findViewById(R.id.toinsurancecard);
        toThePerscription = findViewById(R.id.toperscription);

        toTheInsuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toincard = new Intent(DocumentView.this, InsuranceView.class);
                startActivity(toincard);
            }
        });

        toThePerscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toperscrip = new Intent(DocumentView.this, PerscriptionView.class);
                startActivity(toperscrip);
            }
        });


    }
}
