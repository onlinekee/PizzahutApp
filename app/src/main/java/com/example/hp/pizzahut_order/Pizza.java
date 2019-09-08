package com.example.hp.pizzahut_order;

public class Pizza {
    private int varietyID;
    //private String type;
    private String name;
    private int img;




    public Pizza(int varietyID, String name, int img) {
        this.varietyID = varietyID;
        this.name = name;
        this.img = img;

    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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
