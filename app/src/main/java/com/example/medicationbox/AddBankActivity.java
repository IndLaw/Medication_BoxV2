package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
        FloatingActionButton home = findViewById(R.id.AddBankHome);


        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(AddBankActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String routing = inputRouting.getText().toString().trim();
                int r = Integer.parseInt(routing);
                String accountNo = inputAccountNo.getText().toString().trim();
                int a = Integer.parseInt(accountNo);
                String name = inputName.getText().toString().trim();

                User usr = UserSingleton.getInstance().getUser();
                Bank b = new Bank(r, a, name);
                usr.addPmt(b);
                Toast.makeText(getApplicationContext(), "Payment successfully added.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(AddBankActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });
    }
}
