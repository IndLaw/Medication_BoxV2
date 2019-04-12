package com.example.medicationbox;

abstract class Payment {
    boolean valid;
    String type;

    public void charge(double amt){

    }

    public String getCode(){
        return "";
    }
}
