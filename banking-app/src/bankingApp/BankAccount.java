package bankingApp;

import java.util.Scanner;

public class BankAccount {
    private long balance;
    private long transactionAmount;
    private String currency;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.balance = 0;
        this.transactionAmount = 0;
        this.currency = "€";
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(long amount) {
        if(amount != 0) {
            balance = balance + amount;
            transactionAmount = amount;
        }
    }

    void withdraw(long amount) {
        if(amount != 0) {
            if(amount > balance) {
                System.out.println("You don't have enough funds to withdraw. Check your balance and try again.");
                return;
            }
            balance = balance - amount;
            transactionAmount = -amount;
        }
    }
    void getTransactionDetails(long transactionAmount) {
        if(transactionAmount > 0) {
            System.out.println("You deposited "+currency+" "+transactionAmount+" to your account.");
        } else
        if(transactionAmount < 0) {
            System.out.println("You withdrew "+currency+" "+Math.abs(transactionAmount)+" from your account.");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome "+customerName);
        System.out.println("Your Customer ID is "+customerId);
        System.out.println("Next up are actions available on your account");
        System.out.println("=====================================================================================");
        System.out.println("A. Check account balance");
        System.out.println("B. Deposit funds to account");
        System.out.println("C. Withdraw funds from account");
        System.out.println("D. Last transaction details");
        System.out.println("R. Rename account owner");
        System.out.println("E. Exit");
        System.out.println("=====================================================================================");
        System.out.println("Enter UPPERCASE letter to select an option");
        System.out.println("=====================================================================================");
        option = scanner.nextLine().charAt(0);
        System.out.println("\n");
        do {
            switch (option) {
                case 'A':
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Account name: "+customerName);
                    System.out.println("Account ID: "+customerId);
                    System.out.println("Account balance: "+balance);
                    System.out.println("-----------------------------------------------------------------------------");
                    option = 'X';
                    break;

                case 'B':
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Enter amount to deposit to account");
                    System.out.println("-----------------------------------------------------------------------------");
                    long amountToDeposit = scanner.nextLong();
                    deposit(amountToDeposit);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("You successfully deposited "+amountToDeposit+"€ to your account!");
                    option = 'X';
                    break;
                case 'C':
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Enter amount to withdraw from account");
                    System.out.println("-----------------------------------------------------------------------------");
                    long amountToWithdraw = scanner.nextLong();
                    withdraw(amountToWithdraw);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("You successfully withdrew "+amountToWithdraw+"€ from your account!");
                    option = 'X';
                    break;
                case 'D':
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Getting last transaction amount details...");
                    System.out.println("-----------------------------------------------------------------------------");
                    getTransactionDetails(transactionAmount);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("That's all we have on file for the last transaction. Thanks!");
                    option = 'X';
                    break;
                case 'E':
                    System.out.println("Exiting program.");
                    System.out.println("Thanks for banking with us. You're welcome back any time!");
                    break;
                case 'R':
                    // TODO Rename method is not working correctly
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Account name: "+customerName);
                    System.out.println("Account ID: "+customerId);
                    System.out.println("Account balance: "+balance);
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("To change account owner name type N,");
                    System.out.println("to exit to main options enter any other key.");
                    char input = scanner.next().charAt(0);
                    if(input != 'N') {
                        option = 'X';
                    } else {
                        System.out.println("Enter new name for account owner:");
                        String name = scanner.nextLine();
                        setCustomerName(name);
                        System.out.println("Customer name successfully changed");

                    }
                    break;
                default:
                    System.out.println("OPTIONS: A - Check account balance; B - Deposit funds to account; C - Withdraw funds from account; D - Last transaction details; R - Rename account owner; E - Exit;");
                    System.out.println("Please enter UPPERCASE letter to select an option");
                    System.out.println("=====================================================================================");
                    option = scanner.next().charAt(0);
                    break;
            }
        } while(option != 'E');
            System.out.println("Thanks for banking with us. You're welcome back any time!");
    }

    @Override
    public String toString() {
        return "Bank Account of " + customerName +
                ", customer Id: '" + customerId + '\'' +
                ", current account balance: " + balance +
                ", last transaction amount: " + transactionAmount +
                ", account local currency: '" + currency + '\'';
    }
}
