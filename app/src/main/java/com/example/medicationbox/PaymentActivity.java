package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.TextView;

import java.util.ArrayList;

public class PaymentActivity extends AppCompatActivity {
    int j;
    LinearLayout l;
    User usr;
    ArrayList<Payment> pmt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        usr = UserSingleton.getInstance().getUser();

        ArrayList<TextView> code = new ArrayList<>();
        ArrayList<Button> delete = new ArrayList<>();
        ArrayList<Button> preferred = new ArrayList<>();
        FloatingActionButton home = findViewById(R.id.PaymentHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(PaymentActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        //ADD LAYOUT
        l = findViewById(R.id.activity_payment);
        pmt = usr.getPmts();

        j = 0;
        for (Payment p : pmt) {
            code.add(new TextView(this));
            code.get(j).setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

            if (j == 0) {
                code.get(j).setText(p.getCode() + " PREFERRED");
                l.addView(code.get(j));
            } else {
                code.get(j).setText(p.getCode());
                l.addView(code.get(j));

                preferred.add(new Button(this));
                preferred.get(j - 1).setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                preferred.get(j - 1).setText("Set as Default Payment");
                l.addView(preferred.get(j - 1));

                delete.add(new Button(this));
                delete.get(j - 1).setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                delete.get(j - 1).setText("Delete Payment Method");
                l.addView(delete.get(j - 1));
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
        while (j < delete.size()) {
            delete.get(j).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    usr.removePmt(j + 1);
                    Toast.makeText(getApplicationContext(), "Payment method successfully deleted", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(PaymentActivity.this, Homepage.class);
                    startActivity(i);
                }
            });

            j++;
        }

        j = 0;
        while (j < preferred.size()) {
            preferred.get(j).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Payment p = pmt.get(j + 1);

                    for (int k = j; k >= 0; k--) {
                        pmt.set(k + 1, pmt.get(k));
                    }

                    pmt.set(0, p);

                    Toast.makeText(getApplicationContext(), "Your preferred payment method has been updated", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(PaymentActivity.this, Homepage.class);
                    startActivity(i);
                }
            });
        }
    }
}