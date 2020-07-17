package com.Inheritance;

public class Cat {
    private boolean hasKittens;

    public boolean isHasKittens() {
        return hasKittens;
    }

    public void setHasKittens(boolean hasKittens) {
        this.hasKittens = hasKittens;
    }

    public void eat() {
        System.out.println("Söön hiiri");
    }
    @Override
    public String toString(){
        return super.toString() + ", kassipojad: " + this.hasKittens;
    }
}
