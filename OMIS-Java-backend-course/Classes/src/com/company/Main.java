package com.company;

public class Main {

    public static void main(String[] args) {

	    // write your code here
        /*
        Car BMW = new Car();
        Car Merc = new Car(4,5, "saloon");
        BMW.getDoors();
        BMW.openDoor("sss");
        BMW.setDoors(2);
        BMW.setWheels(8);

        System.out.println(BMW);
        System.out.println(Merc);
        */

        Motorcycle Harley = new Motorcycle(2, "chopper", "no");
        Harley.setWheels(8);
        int harleyWheels = Harley.getWheels();
        System.out.println(harleyWheels);


        Motorcycle buell = new Motorcycle(3, "chopper", "yes");
        buell.setType("superbike");
        String buellWheels = buell.getType();
        System.out.println(buellWheels);

        System.out.println(Harley);
        System.out.println(buell);

    }
}
