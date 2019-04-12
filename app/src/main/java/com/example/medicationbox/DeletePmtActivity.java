package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeletePmtActivity extends AppCompatActivity {
    private TextView prompt;

    protected void onCreate(Bundle savedInstanceState, final User usr, final int i) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletepayment);

        prompt = findViewById(R.id.prompt);

        prompt.setText("Are you sure you want to delete " + usr.pmt[i].getCode() + "?");

        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int j = i;

                while(usr.pmt[j] != null){
                    if(j == usr.pmt.length - 1)
                        usr.pmt[j] = null;
                    else usr.pmt[j] = usr.pmt[j + 1];

                    j++;
                }

                Toast.makeText(getApplicationContext(), "Payment method successfully deleted", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.deny).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(DeletePmtActivity.this, PaymentActivity.class);
                startActivity(i);
            }
        });
    }
}
