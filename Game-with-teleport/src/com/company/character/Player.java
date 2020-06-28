package com.company.character;

import com.company.World;

public class Player extends Character {
    public static Object randomiseCoordinates;
    private static double health;
    private int xCoord;
    private int yCoord;

    public Player(String name, CharacterType type) {
        super(name, type, "X");
        health = 3;
    }

    public static void takeHealth() {
        Player.setHealth(Player.getHealth()-1);
    }
    
    public static double getHealth() {
        return health;
    }

    private static void setHealth(double health) {
        Player.health = health;
    }
    
    public static void setFullHealth() {
        Player.setHealth(10);
    }


}
