package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BoxActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        final User usr = UserSingleton.getInstance().getUser();

        Button home = findViewById(R.id.BoxHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(BoxActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        int j = 0;
        for (Perscription p : usr.shipments.get(usr.shipments.size() - 1).products) {
            TextView med = new TextView(this);
            med.setText(p.getMedName() + " " + p.getDose());
        }
    }
}
