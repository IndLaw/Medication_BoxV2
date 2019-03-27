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
        setContentView(R.layout.activity_addPayment);

        card = (Button) findViewById(R.id.addCard);
        bank = (Button) findViewById(R.id.addBank);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddPmtActivity.this, AddCardActivity.class);
                startActivity(i);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddPmtActivity.this, AddBankActivity.class);
                startActivity(i);
            }
        });
    }
}
