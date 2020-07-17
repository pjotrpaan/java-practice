package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        boolean bool = false;

        Scanner scanner = new Scanner(System.in);

/*
        if (bool) {
            //System.out.printf("Töötab");
        } else {
            //System.out.printf("Ei tööta");
        }
        int code = 1234;

        int code2 = Integer.parseInt(scanner.nextLine());

        switch (code2) {
            case 4322:
                System.out.printf("code not matching");
                break;
            case 1234:
                System.out.printf("code matching");
                break;
            default:
                System.out.printf("code not matching");
        }
*/
        System.out.println("Ütle esimene number ");
        int number1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ütle teine number ");
        int number2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Ütle kolmas number ");
        int number3 = Integer.parseInt(scanner.nextLine());
        int add = number1 + number2 + number3;
        int mult = number1 * number2 * number3;

        if (add % 2 == 0) {
            System.out.printf("Valisid paarissumma");
            numSize(add);
        } else {
            System.out.printf("Valisid paaritu summa");
            numSize(add);

        }



    }

    private static void numSize(int add) {
        if (add > 10) {
            System.out.printf("%nSumma on väiksem/võrdne 10 või suurem kui 5");
        } else if (add <= 10 || add > 5){
            System.out.printf("%nSumma on väiksem kui 10");
        } else {

        }
    }


}
