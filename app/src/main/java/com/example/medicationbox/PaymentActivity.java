package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private Button add, delete;

    protected void onCreate(Bundle savedInstanceState, final User usr) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //show all payments and allow users to change preferred

        add = (Button) findViewById(R.id.addPmt);
        delete = (Button) findViewById(R.id.deletePmt);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(usr.pmt[4] != null){
                    Toast.makeText(getApplicationContext(), "Max number of payment methods reached. Please delete one before adding another.", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(PaymentActivity.this, AddPmtActivity.class);
                    startActivity(i);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(usr.pmt[0] != null){
                    Toast.makeText(getApplicationContext(), "No payment methods to remove.", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(PaymentActivity.this, DeletePmtActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}