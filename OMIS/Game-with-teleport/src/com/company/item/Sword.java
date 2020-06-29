package com.company.item;

import com.company.character.Enemy;

public class Sword extends Item implements Weapon {
    public Sword() {
        super("Sword", 5, 1);
    }

    @Override
    public void hit() {
        Enemy.setHealth(0);
        System.out.println("You used the sword with serious consequences.");
    }
}
