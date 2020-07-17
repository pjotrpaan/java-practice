package com.tryCatch;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            Logger log = Logger.getLogger("src/logs.txt");
            System.out.println("NumberFormatException encountered");
            // e.printStackTrace() // See pole hea näide, vaid see tuleks salvestada logger faili
        }

        try {
            int sum = 7/input;
            int[] nums = new int[0];
            nums = new int[] {1,2,3,4};
            System.out.println(nums[input]);

        } catch (ArithmeticException e) {
            System.out.println("Arvutusviga ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Massiivis pole nii palju elemente ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (RuntimeException e) { // peamine Exception alati viimaseks
            System.out.println("Runtime Exception");
        } catch (Exception e) { // peamine Exception alati viimaseks
            System.out.println("Üldine Exception");
        }


        int[] numbers = new int[0];
        try {
            numbers = new int[] {1,2,3,4};
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(numbers[input]);
    }
}
