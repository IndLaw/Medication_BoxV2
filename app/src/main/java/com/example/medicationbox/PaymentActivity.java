package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    int j;

    protected void onCreate(Bundle savedInstanceState, final User usr) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView code[] = new TextView[5];
        Button delete[] = new Button[4];
        Button preferred[] = new Button[4];

        j = 0;
        while(usr.pmt[j] != null){
            if(j == 0){
                code[j] = new TextView(this);
                code[j].setText(usr.pmt[j].getCode() + " PREFERRED");
            }
            else{
                code[j] = new TextView(this);
                code[j].setText(usr.pmt[j].getCode());
                preferred[j] = new Button(this);
                preferred[j].setText("Set as Default Payment");
                delete[j] = new Button(this);
                delete[j].setText("Delete Payment Method");
            }
            j++;
        }

        findViewById(R.id.addPmt).setOnClickListener(new View.OnClickListener() {
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

        j = 0;
        while(delete[j] != null){
            delete[j].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    Intent i = new Intent(PaymentActivity.this, DeletePmtActivity.class);
                    startActivity(i);
                }
            });
        }

        j = 0;
        while(preferred[j] != null){
            preferred[j].setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    Payment p = usr.pmt[j + 1];

                    for(int k = j; k >= 0; k--){
                        usr.pmt[k + 1] = usr.pmt[j];
                    }

                    usr.pmt[0] = p;

                    Toast.makeText(getApplicationContext(), "Your preferred payment method has been updated", Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}