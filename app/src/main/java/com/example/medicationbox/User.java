package com.example.medicationbox;

import java.util.HashMap;
import android.graphics.Bitmap;

public class User{

    String name;
    String email;
    String password;
    Payment pmt[] = new Payment[5]; //users can have up to 5 different payments, first is preferred
    String userUID;
    Perscription[] perscriptions = new Perscription[10];
    Insurance insurance;
    int numPercriptions;
    HashMap<String, Bitmap> pictures;

    public User(String name, String email, String userUID, String password)
    {
        this.name = name;
        this.email = email;
        this.userUID = userUID;
        this.password = password;
        this.numPercriptions = 0;
        this.perscriptions = new Perscription[10];
        this.pictures = new HashMap<String, Bitmap>();
	}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }

    public String getEmail() { return email; }

    public String getUID() { return userUID; }

    public Perscription[] getAllPerscriptions() {
        return perscriptions;
    }

    public Perscription getPerscription(String medName) {
        String arrayMedName = "";
        for (int i = 0; perscriptions[i] != null; i++) {
            arrayMedName = perscriptions[i].getMedName();
            if (arrayMedName.equals(medName)) {
                return perscriptions[i];
            }
        }
        return null;
    }

    public void addPerscription(Perscription perscription) {
        perscriptions[numPercriptions] = perscription;
        numPercriptions++;
    }

    public Perscription removePerscription(String medName) {
        String arrayMedName = "";
        for (int i = 0; perscriptions[i] != null; i++) {
            arrayMedName = perscriptions[i].getMedName();
            if (arrayMedName.equals(medName)) {
                Perscription per = perscriptions[i];
                for(int k = i; k < numPercriptions; k++) {
                    perscriptions[k] = perscriptions[k + 1];
                }
                numPercriptions--;
                return per;
            }
        }
        return null;
    }

    public HashMap<String, Bitmap> getPictures() {
        return pictures;
    }

    public void setPictures(HashMap<String, Bitmap> pictures) {
        this.pictures = pictures;
    }

    public Bitmap addPicture(String picID, Bitmap picture) {
        pictures.put(picID, picture);
        return pictures.get(picID);
    }

    public Bitmap getPicture(String picID) {
        return pictures.get(picID);
    }

    public Bitmap removePicture(String picID) {
        return pictures.remove(picID);
    }

    public Bitmap changePicture(String picID, Bitmap picture) {
        pictures.put(picID, picture);
        return pictures.get(picID);
    }
}
