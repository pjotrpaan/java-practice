package com.Generics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        ArrayList<Integer> items = new ArrayList<>();
//
//        items.add(1);
//        items.add(2);
//        items.add(3);
////        items.add("üks");
//        items.add(4);
//        items.add(5);
//        items.add(6);
//
//        for (Object o:items) {
//            System.out.println(o);
//        }

        Car audi = new Car("Audi");
        Motorcycle harley = new Motorcycle("Harley Davidson");
        Plane airbus = new Plane("Airbus");

        Fleet<Vehicle> fleet = new Fleet();
        fleet.addToFleet(audi);
        fleet.addToFleet(harley);
        fleet.addToFleet(airbus);
        fleet.addToFleet(airbus);


        for (Vehicle v: fleet.getFleetVehicles()) {
            System.out.println(v);
        }

        System.out.println(Fleet.getFleetVehicles(fleet));

    }
}
