package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Kuigi chair on juba loodud enne 10. rea väljatrüki algust, siis miks seal kajastub algne hind ja järgneval juba objektile määratud hind?");
        Chair chair = new Chair(10.20, "plastik", true);
        //Furniture furniture = new Furniture();
        System.out.println("Miks mina olen veel algne 0.0? " + chair.getPrice());
        System.out.println("Aga mina juba chair initsialiseerimisel määratud hind? " + chair.getPrice());
        System.out.println("Main function chair.getPriceInUSD() 1: " + chair.getPriceInUSD());
        //System.out.println("Furniture: " + furniture);
        //
        chair.setPrice(30.00);

        //
        System.out.println("Peale setPrice() tegemist oleks edasi kõik justkui normaalne ja hind on kohe muutunud.");
        System.out.println("Main function chair.price peale setPrice(30.00): " + chair.getPrice());
        System.out.println("Main function chair.getPrice() peale setPrice(30.00): " + chair.getPrice());
        System.out.println("Main function chair.getPriceInUSD() peale setPrice(30.00): " + chair.getPriceInUSD());
    }
}
