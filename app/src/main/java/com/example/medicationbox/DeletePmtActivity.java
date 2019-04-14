package com.example.medicationbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DeletePmtActivity extends AppCompatActivity {
    private TextView prompt;

    protected void onCreate(Bundle savedInstanceState, final int i) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletepayment);
        final User usr = UserSingleton.getInstance().getUser();

        prompt = findViewById(R.id.prompt);

        prompt.setText("Are you sure you want to delete " + usr.pmt.get(i).getCode() + "?");

        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                usr.pmt.remove(i);
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
