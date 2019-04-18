package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class BoxActivity extends AppCompatActivity {
    User usr = UserSingleton.getInstance().getUser();
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
    LinearLayout l;
    int j;

    Box box = usr.getBox(0);

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

        //ADD LAYOUT
        l = findViewById(R.id.activity_box);
        ArrayList<Button> delete = new ArrayList<>();

        //display contents of box
        //plus buttons to opt for physical pickup
        j = 0;
        for (Perscription p : box.products) {
            TextView med = new TextView(this);
            med.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            med.setText(p.getMedName() + " " + p.getDose());
            l.addView(med);

            delete.add(new Button(this));
            delete.get(j).setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            delete.get(j).setText("Opt for physical pickup");
            l.addView(delete.get(j));

            j++;
        }

        j = 0;
        while (j < delete.size()) {
            delete.get(j).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Perscription p = box.removeMed(j - 1);
                    Toast.makeText(getApplicationContext(), "You have successfully opted for physical pickup of " + p.getMedName(), Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(getIntent());
                }
            });

            j++;
        }

        //reschedule
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
