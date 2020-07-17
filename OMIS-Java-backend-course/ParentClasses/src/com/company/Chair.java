package com.company;

public class Chair extends Furniture {
    private double price;

    public Chair(double price, String material, boolean restored) {
        super(price, material, restored);
    }

    /*public void setPrice(double price) {
        this.price = price;
    }*/
    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public double getPriceInUSD() {
        return super.getPriceInUSD();
    }


    @Override
    public String getMaterial() {
        return super.getMaterial();
    }

    @Override
    public void setMaterial(String material) {
        super.setMaterial(material);
    }

    @Override
    public boolean isRestored() {
        return super.isRestored();
    }

    @Override
    public void setRestored(boolean restored) {
        super.setRestored(restored);
    }
}
