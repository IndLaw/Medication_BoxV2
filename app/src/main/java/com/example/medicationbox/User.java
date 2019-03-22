package com.example.medicationbox;

import android.os.Parcel;
import android.os.Parcelable;

public class User{

    String name;
    String email;
    String userUID;

    public User(String name, String email, String password, String userUID)
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

}
