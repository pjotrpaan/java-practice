package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner= new Scanner(System.in);
	    String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        int num1 = Integer.parseInt(input1);
        int num2 = Integer.parseInt(input2);
        int sum = num1 + num2;
        double double1 = Double.parseDouble(input1);
        double double2 = Double.parseDouble(input2);
        double jagatis = double1 / double2;
        //int jagatiseInt = jagatis.parseDouble
        int korrutis = num1 * num2;
        // System.out.println(num1 + num2 + "Kahe arvu summa on " );
        // System.out.println("Kahe arvu summa on " );
        System.out.printf("Arvude summa on %d%n", num1 + num2);
        // System.out.printf("%d ja %d summa on %d", num1, num2, sum);

        // Lahutamine
        System.out.printf("Arvude lahutamise jääk on %d%n", num1 - num2);


        // Jagamine -
        // OLULINE {DOUBLE} (castimine) (double <name> = Double.parseDouble(<input>);
        System.out.printf("Arvude jagatis on " + jagatis + "%n");
        // ERROR
        System.out.printf("Kahe arvu jagatis on %.2f%n", jagatis);

        // Korrutamine
        System.out.printf("Arvude korrutis on " + korrutis + "%n");


    }
}
