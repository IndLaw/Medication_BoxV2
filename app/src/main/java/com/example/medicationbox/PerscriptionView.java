package com.example.medicationbox;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perscription_enter);

        perscriptionNext = (Button) findViewById(R.id.nextperscription);
        paname = (EditText) findViewById(R.id.patientsname);
        paaddress = (EditText) findViewById(R.id.patientsaddress);
        docname = (EditText) findViewById(R.id.doctorname);
        docaddress = (EditText) findViewById(R.id.doctorsaddress);
        paage = (EditText) findViewById(R.id.patientsage);
        numrefills = (EditText) findViewById(R.id.refillnum);
        medicationname = (EditText) findViewById(R.id.medsname);
        dosedescription = (EditText) findViewById(R.id.perscripdose);

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

                Perscription perscrip = new Perscription(dName, pName, pAge, dAddress, pAddress, mName, rNum, pdose);
            }
        });
    }




}
