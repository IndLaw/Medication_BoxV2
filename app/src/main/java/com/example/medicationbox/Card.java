package com.example.medicationbox;

import java.util.Date;

public class Card extends Payment {
    private int number;
    private String cardholder;
    private Date expire;
    private int csv;

    Card(int number, String cardholder, Date expire, int csv)
    {
        this.number = number;
        this.cardholder = cardholder;
        this.expire = expire;
        this.csv = csv;
    }

    @Override
    public void charge(double amt){

    }

}
