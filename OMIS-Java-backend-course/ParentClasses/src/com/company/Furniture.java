package com.company;

public class Furniture {
    private double price;
    public String material;
    public boolean restored;

    public Furniture(double price, String material, boolean restored) {
        this.price = price;
        this.material = material;
        this.restored = restored;
    }

    public double getPrice() {
        return price;
    }
    public double getPriceInUSD() {
        double hind = this.price*1.1;
        return hind;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println(this.price);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isRestored() {
        return restored;
    }

    public void setRestored(boolean restored) {
        this.restored = restored;
    }
}
