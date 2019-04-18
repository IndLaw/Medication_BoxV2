package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddPmtActivity extends AppCompatActivity {
    private Button card, bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpayment);

        card = findViewById(R.id.addCard);
        bank = findViewById(R.id.addBank);
        Button home = findViewById(R.id.AddPaymentHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddPmtActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddPmtActivity.this, AddCardActivity.class);
                startActivity(i);
            }
        });

        bank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddPmtActivity.this, AddBankActivity.class);
                startActivity(i);
            }
        });
    }
}
