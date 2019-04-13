package com.example.medicationbox;

import java.util.ArrayList;

public class User{

    private String name;
    private String email;
    public ArrayList<Payment> pmt = new ArrayList<>();
    private String userUID;
    private ArrayList<Perscription> perscriptions = new ArrayList<>();
    private Insurance insurance;
    private ArrayList<Box> shipments = new ArrayList<>();

    public User(String name, String email, String userUID)
    {
        this.name = name;
        this.email = email;
        this.userUID = userUID;
	}
	
    public String getName() {
        return name;
    }

    public String getEmail() { return email;}

    public String getUID() { return userUID; }

    public Perscription getPerscription(String medName) {
        for (Perscription p : perscriptions) {
            if (medName.equals(p.getMedName())) {
                return p;
            }
        }
        return null;
    }

    public void addPerscription(Perscription perscription) {
        perscriptions.add(perscription);
    }

    public boolean removePerscription(String medName) {
        return perscriptions.remove(medName);
    }
}
