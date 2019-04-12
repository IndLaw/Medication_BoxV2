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

    public String getPicID() {
        return picID;
    }

    public void setPicID(String picID) {
        this.picID = picID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
}
