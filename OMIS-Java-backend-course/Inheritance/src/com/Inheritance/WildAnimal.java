package com.Inheritance;

public class WildAnimal extends Animal {
    @Override
    public String getName() {
        return "Metsloomadel pole nime";
    }

    @Override
    public void setName(String name) {
        System.out.println("Metsloomadel pole nime");
        if (name.equals("BSH")) {
            super.setName(name);
        }
    }
}
