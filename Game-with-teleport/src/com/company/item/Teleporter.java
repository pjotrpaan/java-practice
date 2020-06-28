package com.company.item;

import com.company.character.Enemy;

public class Teleporter extends Item {
    private static double strength = 0.5;

    public Teleporter() {
        super("Teleporter", strength, 1);
    }

    public void teleport() {
        double healthLeft = Enemy.getHealth() - strength;
        Enemy.setHealth(healthLeft);
        System.out.println("Põgenesid teleporteri abil.");
    }
}
