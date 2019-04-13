package com.example.medicationbox;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Box {
    private ArrayList<Perscription> products;
    private Calendar shipmentDate;
    User usr;

    public Box(User usr){
        shipmentDate = earliestShip();
        this.usr = usr;
    }

    private Calendar earliestShip(){
        if(usr.shipments.size() == 0){
            return Calendar.getInstance();
        }
        else {
            shipmentDate = usr.shipments.get(usr.shipments.size() - 1).shipmentDate;
            shipmentDate.add(Calendar.DATE, Integer.parseInt(usr.perscriptions.get(0).getQuantity()));
            return shipmentDate;
        }
    }

    public void addMed(Perscription p){
        products.add(p);
    }

    public void removeMed(Perscription p){
        products.remove(p);
    }

    public void changeDate(Calendar c){
        shipmentDate = c;
    }
}
