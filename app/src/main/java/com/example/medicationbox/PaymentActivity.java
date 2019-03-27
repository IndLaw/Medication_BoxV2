package com.example.medicationbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity {

    private Button add;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void addPayment(boolean card){ //if true, adding card, if false, adding bank
        if(usr.pmt[4] != null){
            //print message that max # of payment methods have been reached, user must delete one before adding another
        }
        else{
            for(int i = 0; usr.pmt[i] != null; i++);

            if(card)
                addCard(i);
            else
                addBank(i);
        }
    }

    private void addCard(int i){
        //add card input popup
    }

    private void addBank(int i){
       //add card input popup
    }

    public void deletePayment(int index){
        usr.pmt[index] = usr.pmt[4];
        usr.pmt[4] = NULL;
    }
}
