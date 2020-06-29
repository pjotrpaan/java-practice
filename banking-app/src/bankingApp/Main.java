package bankingApp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Thanks for choosing our bank! Let's get started!");
        System.out.println("Please enter your full name for your account application");
        String customerName = scanner.nextLine();
        System.out.println("Thanks! Just finishing the registration. You will be forwarded to the program menu.");
        BankAccount NewBankAccount  = new BankAccount(customerName, "BANKALAMPA001");
        NewBankAccount.showMenu();
    }
}
