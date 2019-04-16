package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class BoxActivity extends AppCompatActivity {
    User usr = UserSingleton.getInstance().getUser();
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box);

        Button home = findViewById(R.id.BoxHome);

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(BoxActivity.this, Homepage.class);
                startActivity(i);
            }
        });

        //display contents of box
        for (Perscription p : usr.shipments.get(usr.shipments.size() - 1).products) {
            TextView med = new TextView(this);
            med.setText(p.getMedName() + " " + p.getDose());
        }

        //popup for if reschedule button is clicked
 /*       findViewById(R.id.reschedule).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dateView = findViewById(R.id.textView3);
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                Calendar c = Calendar.getInstance();
                c.set(datePicker.getDayOfMonth(), datePicker.getMonth() + 1, datePicker.getYear());


                @SuppressWarnings("deprecation")
                public void setDate(View view) {
                    showDialog(999);
                    Toast.makeText(getApplicationContext(), "ca",
                            Toast.LENGTH_SHORT)
                            .show();
                }

                usr.shipments.get(usr.shipments.size() - 1).changeDate(c);
            }
        });*/
    }
}
