package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PerscriptionView extends AppCompatActivity {

    private Button perscriptionNext;
    private EditText paname;
    private EditText paaddress;
    private EditText docname;
    private EditText docaddress;
    private EditText paage;
    private EditText numrefills;
    private EditText medicationname;
    private EditText dosedescription;
    private EditText quantity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perscription_enter);

        perscriptionNext = findViewById(R.id.nextperscription);
        paname = findViewById(R.id.patientsname);
        paaddress = findViewById(R.id.patientsaddress);
        docname = findViewById(R.id.doctorname);
        docaddress = findViewById(R.id.doctorsaddress);
        paage = findViewById(R.id.patientsage);
        numrefills = findViewById(R.id.refillnum);
        medicationname = findViewById(R.id.medsname);
        dosedescription = findViewById(R.id.perscripdose);
        quantity = findViewById(R.id.perquantity);
        Button home = findViewById(R.id.PerscripEnterHome);


        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(PerscriptionView.this, Homepage.class);
                startActivity(i);
            }
        });

        perscriptionNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dName = docname.getText().toString();
                String pName = paname.getText().toString();
                String paAge1 = paage.getText().toString();
                int pAge = Integer.parseInt(paAge1);
                String dAddress = docaddress.getText().toString();
                String pAddress = paaddress.getText().toString();
                String mName = medicationname.getText().toString();
                String rNum1 = numrefills.getText().toString();
                int rNum = Integer.parseInt(rNum1);
                String pdose = dosedescription.getText().toString();
                String pquantity = quantity.getText().toString();

                Perscription perscrip = new Perscription(dName, pName, pAge, dAddress, pAddress, mName, rNum, pdose, pquantity);

                UserSingleton.getInstance().getUser().addPerscription(perscrip);
            }
        });
    }
}