package com.Generics;

import java.util.ArrayList;
import java.util.List;

public class Fleet<T> {
    private ArrayList<T> fleetVehicles = new ArrayList<>();


    public boolean addToFleet(T vehicle) {

        if (fleetVehicles.contains(vehicle)){
            System.out.println(((Vehicle)vehicle).getBrand() + " on juba liikluses.");
            return false;
        } else {
            fleetVehicles.add(vehicle);
            System.out.println(((Vehicle)vehicle).getBrand() + " lisati liiklusesse.");
            return true;
        }

    }

    public ArrayList<T> getFleetVehicles() {
        return fleetVehicles;
    }

    public static getFleetVehicles(List<T> list) {
        return list.get(0);
    }


}
