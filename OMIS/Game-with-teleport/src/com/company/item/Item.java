package com.company.item;

import com.company.World;
import com.company.WorldObject;

public class Item implements WorldObject {
    private int xCoord;
    private int yCoord;

    private String name;
    private double strength;
    private int endurance;
    private int level;
    private ItemType itemType;
    private String symbol;

    public Item(String name, double strength, int endurance) {
        randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
        this.name = name;
        this.strength = strength;
        this.endurance = endurance;
        this.level = 1;
        this.itemType = getRandomItemType();
        this.symbol = "i";
//        getRandomItempType();
    }

    public void randomiseCoordinates(int min, int worldWidth, int worldHeight) {
        this.xCoord = (int) ((Math.random() * ((worldWidth - min) + 1)) + min);
        this.yCoord = (int) ((Math.random() * ((worldHeight - min) + 1)) + min);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    private ItemType getRandomItemType() {
       return ItemType.STANDARD;
    }

    public String getName() {
        return name;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return name + " tugevusega " + strength*1 + ". Kasutuskordi: " + endurance;
    }
}
