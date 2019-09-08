package com.example.hp.pizzahut_order;

public class Pizza {
    private int varietyID;
    //private String type;
    private String name;
    //private int img;


    public Pizza(int varietyID, String name) {
        this.varietyID = varietyID;
        this.name = name;
    }

    public int getVarietyID() {
        return varietyID;
    }

    public void setVarietyID(int varietyID) {
        this.varietyID = varietyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
