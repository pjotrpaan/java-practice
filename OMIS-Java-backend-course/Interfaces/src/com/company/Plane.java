package com.company;

public class Plane {
    private boolean isUp;

    @Override
    public void drive() {
        this.isUp = true;
        System.out.println("On õhus " + isUp);
        System.out.println(doors);
    }
}
