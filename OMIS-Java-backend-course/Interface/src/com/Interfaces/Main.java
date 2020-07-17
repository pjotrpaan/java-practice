package com.Interfaces;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EstPersonalCode EE = new EstPersonalCode("30887310307");
        System.out.println("Eestlane, " + EE.getSugu());

        FinPersonalCode FI = new FinPersonalCode();
        System.out.println("Soomlane, " + FI.getSugu());

        SwePersonalCode SE = new SwePersonalCode("811228-9875");
        System.out.println("Rootslane, " + SE.getSugu());

    }
}
