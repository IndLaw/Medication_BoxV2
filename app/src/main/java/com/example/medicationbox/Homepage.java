package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        Button box, doc, pay;

        box = findViewById(R.id.gotobox);
        doc = findViewById(R.id.uploadDoc);
        pay = findViewById(R.id.topayments);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent tobox = new Intent(Homepage.this, RegisterActivity.class);
                startActivity(tobox);
            }
        });

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent todoc = new Intent(Homepage.this, DocumentView.class);
                startActivity(todoc);
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent topay = new Intent(Homepage.this, PaymentActivity.class);
                startActivity(topay);
            }
        });
    }

}
