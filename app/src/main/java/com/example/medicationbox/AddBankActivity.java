package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class AddBankActivity extends AppCompatActivity {
    private Button confirm;
    private EditText inputRouting, inputAccountNo, inputName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbank);

        confirm = findViewById(R.id.confirm);
        inputRouting = findViewById(R.id.routing);
        inputAccountNo = findViewById(R.id.accountNo);
        inputName = findViewById(R.id.name);
        Button home = findViewById(R.id.PaymentHome);


        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddBankActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            String routing = inputRouting.getEditableText().toString().trim();
            String accountNo = inputAccountNo.getEditableText().toString().trim();
            String name = inputName.getEditableText().toString().trim();

            public void onClick(View view) {
                UserSingleton.getInstance().getUser().pmt.add(new Bank(Integer.parseInt(routing), Integer.parseInt(accountNo), name));
                Toast.makeText(getApplicationContext(), "Payment successfully added.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddBankActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });
    }
}
