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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        final User usr = UserSingleton.getInstance().getUser();

        TextView code[] = new TextView[5];
        Button delete[] = new Button[4];
        Button preferred[] = new Button[4];

        j = 0;
        for(Payment p : usr.pmt){
            if(p == usr.pmt.get(0)){
                code[j] = new TextView(this);
                code[j].setText(p.getCode() + " PREFERRED");
            }
            else{
                code[j] = new TextView(this);
                code[j].setText(p.getCode());
                preferred[j] = new Button(this);
                preferred[j].setText("Set as Default Payment");
                delete[j] = new Button(this);
                delete[j].setText("Delete Payment Method");
            }
            j++;
        }

        findViewById(R.id.addPmt).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(PaymentActivity.this, AddPmtActivity.class);
                startActivity(i);
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
                    Payment p = usr.pmt.get(j + 1);

                    for(int k = j; k >= 0; k--){
                        usr.pmt.set(k + 1, usr.pmt.get(j));
                    }

                    usr.pmt.set(0, p);

                    Toast.makeText(getApplicationContext(), "Your preferred payment method has been updated", Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}