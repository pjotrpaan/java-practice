package com.company.item;

import com.company.character.Enemy;

public class Hammer extends Item implements Weapon {
    private static double strength = 5;

    public Hammer() {
        super("Hammer", strength, 1);
    }

    @Override
    public void hit() {
        double healthLeft = Enemy.getHealth() - strength;
        Enemy.setHealth(healthLeft);
        System.out.println("You gave enemy a good blow with the hammer.");
    }
}
