package com.example.medicationbox;

import java.util.Date;

public class Card extends Payment {
    private int number;
    private String cardholder;
    private Date expiry;
    private int csv;
    public final String type = "card";

    Card(int number, String cardholder, Date expiry, int csv)
    {
        this.number = number;
        this.cardholder = cardholder;
        this.expiry = expiry;
        this.csv = csv;
    }

    @Override
    public String getCode(){
        return "XXXX-XXXX-XXXX-" + Integer.toString(number).substring(12);
    }

    @Override
    public void charge(double amt){

    }

}
