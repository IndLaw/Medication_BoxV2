package com.example.medicationbox;

public class User{

    String name;
    String email;
    String password;
    Payment pmt[] = new Payment[5]; //users can have up to 5 different payments, first is preferred
    String userUID;
    Perscription[] perscriptions = new Perscription[10];
    Insurance insurance;
    int numPercriptions;

    public User(String name, String email, String userUID, String password)
    {
        this.name = name;
        this.email = email;
        this.userUID = userUID;
        this.password = password;
        numPercriptions = 0;
        perscriptions = new Perscription[10];
	}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getName() {
        return name;
    }

    public String getEmail() { return email;}

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
}
