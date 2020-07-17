package com.company;

public class Car {

    int wheels;
    int doors;
    String type;

    // Public tähendab, et funktsiooni saab kasutada igal pool


    public Car(int wheels, int doors, String type) {
        this.wheels = wheels;
        this.doors = doors;
        this.type = type;
    }
    public Car() {

    }

    public int getDoors() {
        System.out.println("Doors given");
        return doorsCalc();
    }

    private int doorsCalc() {
        this.wheels = 6;
        return doors*4;
    }

    // Kui ei soovi midagi funktsiooniga tagastada kasuta void tüübi asemel
    public void openDoor(String tyyp) {
        System.out.println("Doors opened");
    }
    public void openDoor(String tyyp, int any) {
        System.out.println("Doors opened");
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", doors=" + doors +
                ", type='" + type + '\'' +
                '}';
    }
}
