package com.example.hp.pizzahut_order;

public class Pizza {
    private int varietyID;
    //private String type;
    private String name;
    private int img;
    private int typeID;


    public Pizza(int typeID, int varietyID, String name, int img) {
        this.typeID = typeID;
        this.varietyID = varietyID;
        this.name = name;
        this.img = img;

    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
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


}
