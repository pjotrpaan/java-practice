package com.Inheritance;

public class Animal {
    private String name;
    private String breed;
    private int age;
    private double weight;
    private boolean isAlive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void eat() {
        System.out.println("Söön krõbinaid");
    }

    public void sleep() {
        System.out.println("Magan metsas");
    }

    @Override
    public String toString() {
        return "Olen loom {" +
                "nimi='" + name + '\'' +
                ", tõug='" + breed + '\'' +
                ", vanus=" + age +
                ", kaal=" + weight +
                ", olenElus=" + isAlive +
                '}';
    }
}

