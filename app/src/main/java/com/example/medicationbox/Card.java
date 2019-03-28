package com.example.medicationbox;

import java.util.Date;

public class Card extends Payment {
    private int number;
    private String cardholder;
    private Date expiry;
    private int csv;

    Card(int number, String cardholder, Date expiry, int csv)
    {
        this.number = number;
        this.cardholder = cardholder;
        this.expiry = expiry;
        this.csv = csv;
    }

    @Override
    public void charge(double amt){

    }

}
