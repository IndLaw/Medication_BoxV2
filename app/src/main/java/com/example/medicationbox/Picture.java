package com.example.medicationbox;

public class Picture {
    String picID;
    User user;
    byte[] pic;

    public Picture(String picID, User user, byte[] pic) {
        this.picID = picID;
        this.user = user;
        this.pic = pic;
    }
}
