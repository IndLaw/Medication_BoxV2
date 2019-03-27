package com.example.medicationbox;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class AddBankActivity extends AppCompatActivity {
    private Button confirm;
    private TextInputLayout inputRouting, inputAccountNo, inputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        confirm = (Button) findViewById(R.id.confirm);
        inputRouting = (TextInputLayout) findViewById(R.id.routing);
        inputAccountNo = (TextInputLayout) findViewById(R.id.accountNo);
        inputName = (TextInputLayout) findViewById(R.id.Name);

        confirm.setOnClickListener(new View.OnClickListener() {
            String routing = inputRouting.getEditText().getText().toString().trim();
            String accountNo = inputAccountNo.getEditText().getText().toString().trim();
            String name = inputName.getEditText().getText().toString().trim();

            public void onClick(View view) {
                for(int i = 0; usr.pmt[i] != null; i++);
                pmt[i] = new Bank(Integer.parseInt(routing), cardholder, new SimpleDateFormat("MM,yy").parse(expiry), Integer.parseInt(csv));
                Toast.makeText(getApplicationContext(), "Payment successfully added.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
