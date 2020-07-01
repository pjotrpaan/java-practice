package com.company.character;

public class Enemy extends Character {
    private static double health;

    public Enemy(String name, CharacterType type) {
        super(name, type, "Z");
        health = 5;
    }

    public static double getHealth() {
        return health;
    }

    public static void setHealth(double health) {
        Enemy.health = health;
    }

    public static void reboost() {
        Enemy.health = 10;
    }

}
