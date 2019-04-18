package com.example.medicationbox;

import java.util.ArrayList;
import java.util.Calendar;

public class Box {
    public ArrayList<Perscription> products;
    private Calendar shipmentDate;
    User usr;

    public Box(int i){
        products = new ArrayList<>();

        if(i == 0){
            shipmentDate = Calendar.getInstance();
        }
        else {
            Calendar earliest = usr.shipments.get(usr.shipments.size() - 1).shipmentDate;
            earliest.add(Calendar.DATE, Integer.parseInt(usr.perscriptions.get(0).getQuantity()));
            shipmentDate = earliest;
        }

        for( Perscription p : usr.perscriptions){
            products.add(p);
        }
        
        usr = UserSingleton.getInstance().getUser();
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
