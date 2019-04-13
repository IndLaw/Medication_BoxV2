package com.example.medicationbox;

public class UserSingleton {
    private static UserSingleton instance;

    // Global variable
    private User currentUser;

    // Restrict the constructor from being instantiated
    private UserSingleton(){}

    public void setUser(User user){
        this.currentUser = user;
    }
    public User getUser(){
        return this.currentUser;
    }

    public static synchronized UserSingleton getInstance(){
        if(instance==null){
            instance=new UserSingleton();
        }
        return instance;
    }
}
