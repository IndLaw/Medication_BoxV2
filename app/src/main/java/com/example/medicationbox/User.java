package com.example.medicationbox;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String email;
    String password;
    Payment pmt[];

    public User(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        pmt = new Payment[5]; //users can have up to 5 different payments, first is preferred
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
