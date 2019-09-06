package com.example.hp.pizzahut_order;

public class Pizza {
    private String variety;
    private String type;
    private String name;
    private int img;

    public Pizza(String variety, String type, String name, int img) {
        this.variety = variety;
        this.type = type;
        this.name = name;
        this.img = img;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return name;
    }
}
