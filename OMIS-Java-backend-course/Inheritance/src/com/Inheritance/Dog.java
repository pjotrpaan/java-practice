package com.Inheritance;

public class Dog extends Pet {
    private boolean hasLongFur;
    private int age;


    public boolean isHasLongFur() {
        return hasLongFur;
    }

    public void setHasLongFur(boolean hasLongFur) {
        this.hasLongFur = hasLongFur;
    }

    public void chaseCat() {
        System.out.println("Kassijahil");
    }

    @Override
    public int getAge() {
        return this.age = super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void eat() {
        System.out.println("Söön koeratoitu");
    }
    @Override
    public String toString(){
        return super.toString() + ", pikk karv: " + this.hasLongFur;
    }
}
