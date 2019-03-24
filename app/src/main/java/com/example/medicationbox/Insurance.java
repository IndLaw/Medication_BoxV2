package com.example.medicationbox;

public class Insurance {
    private String name;
    private int policy;
    private String plan;
    private int copay;
    private String company;

    public Insurance(String name, int policy, String plan, int copay, String company) {
        this.name = name;
        this.policy = policy;
        this.plan = plan;
        this.copay = copay;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPolicy() {
        return policy;
    }

    public void setPolicy(int policy) {
        this.policy = policy;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getCopay() {
        return copay;
    }

    public void setCopay(int copay) {
        this.copay = copay;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
