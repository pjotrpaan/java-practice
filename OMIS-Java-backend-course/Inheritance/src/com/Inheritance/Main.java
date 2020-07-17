package com.Inheritance;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dog spot = new Dog();

        spot.isHasLongFur();
        spot.setAge(8);
        spot.setOwner("Pets");
        spot.setAlive(true);

        System.out.println(spot);

        Wolf wolf = new Wolf();
        System.out.println(wolf);

        wolf.setName("BSH");
        System.out.println(wolf);

        Animal animal = new Animal();
        System.out.println(animal.getName());

        animal.setName("Uus nimi");
        System.out.println(animal.getName());

    }
}
