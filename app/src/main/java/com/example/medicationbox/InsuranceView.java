package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsuranceView extends AppCompatActivity {

    private Button nextinsurancebutton;
    private EditText ipatientname;
    private EditText ipolicynumber;
    private EditText iplanname;
    private EditText icopayment;
    private EditText icompanyname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_enter);

        nextinsurancebutton = findViewById(R.id.insurancenext);
        ipatientname = findViewById(R.id.ipname);
        ipolicynumber = findViewById(R.id.ipolicynum);
        iplanname = findViewById(R.id.iplanname);
        icopayment = findViewById(R.id.icopayment);
        icompanyname = findViewById(R.id.icompanyname);
        FloatingActionButton home = findViewById(R.id.InsuranceEnterHome);


        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(InsuranceView.this, Homepage.class);
                startActivity(i);
            }
        });

        nextinsurancebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ipn = ipatientname.getText().toString();
                String ipnum1 = ipolicynumber.getText().toString();
                int ipnum = Integer.parseInt(ipnum1);
                String ipln = iplanname.getText().toString();
                String icop1 = icopayment.getText().toString();
                int icop = Integer.parseInt(icop1);
                String icn = icompanyname.getText().toString();

                Insurance insuranceCard = new Insurance(ipn, ipnum, ipln, icop, icn);

                UserSingleton.getInstance().getUser().setInsurance(insuranceCard);

                Intent i = new Intent(InsuranceView.this, DocumentView.class);
                startActivity(i);
            }
        });
    }
}
