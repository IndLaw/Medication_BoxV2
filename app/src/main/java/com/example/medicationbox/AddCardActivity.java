package com.example.medicationbox;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class AddCardActivity extends AppCompatActivity {
    private Button confirm;
    private TextInputLayout inputNumber, inputCardholder, inputExpiry, inputCsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = (Button) findViewById(R.id.confirm);
        inputNumber = (TextInputLayout) findViewById(R.id.number);
        inputCardholder = (TextInputLayout) findViewById(R.id.cardholder);
        inputExpiry = (TextInputLayout) findViewById(R.id.expiry);
        inputCsv = (TextInputLayout) findViewById(R.id.csv);

        confirm.setOnClickListener(new View.OnClickListener() {
            String number = inputNumber.getEditText().getText().toString().trim();
            String cardholder = inputCardholder.getEditText().getText().toString().trim();
            String expiry = inputExpiry.getEditText().getText().toString().trim();
            String csv = inputCsv.getEditText().getText().toString().trim();

            public void onClick(View view) {
                for(int i = 0; usr.pmt[i] != null; i++);
                pmt[i] = new Card(Integer.parseInt(number), cardholder, new SimpleDateFormat("MM,yy").parse(expiry), Integer.parseInt(csv));
                Toast.makeText(getApplicationContext(), "Payment successfully added.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
