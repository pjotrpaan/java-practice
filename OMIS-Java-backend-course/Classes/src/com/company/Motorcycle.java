package com.company;

public class Motorcycle {
    private int wheels;
    private String type;
    private String sidecar;

    public Motorcycle(int wheels, String type, String sidecar) {
        this.wheels = wheels;
        this.type = type;
        this.sidecar = sidecar;
    }

    public String getSidecar() {
        return sidecar;
    }

    public void setSidecar(String sidecar) {
        this.sidecar = sidecar;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "wheels=" + wheels +
                ", type='" + type + '\'' +
                '}';
    }
}
