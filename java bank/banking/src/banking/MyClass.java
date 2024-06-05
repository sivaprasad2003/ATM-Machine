package banking;

import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number: ");
        String accountId = sc.nextLine();

        System.out.println("\nEnter account name: ");
        String accountName = sc.nextLine();

        System.out.println("\nEnter PIN: ");
        int pin = sc.nextInt();

        if (pin >= 1000 && pin <= 9999) {
            BankAccount account = new BankAccount(accountId, accountName);
            int option = 0;
            while (option != 5) {
                System.out.println("\nSelect Options Below \n" 
                		+ "1. Deposit \n" 
                        + "2. Withdraw \n"
                		+ "3. Balance \n"
                		+ "4. PIN Change \n"
                		+ "5. Exit");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("\nEnter amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.println("\nEnter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.checkBalance();
                        break;
                    case 4:
                        System.out.println("\nEnter old PIN: ");
                        int oldPin = sc.nextInt();
                        if (oldPin == pin) {
                            System.out.println("\nEnter new PIN: ");
                            int newPin = sc.nextInt();
                            if (newPin >= 1000 && newPin <= 9999) {
                                System.out.println("Your PIN was changed successfully");
                                pin = newPin;
                            } else {
                                System.out.println("\nInvalid PIN...It must be a 4-digit number");
                            }
                        } else {
                            System.out.println("\nWrong PIN");
                        }
                        break;
                    case 5:
                        System.out.println("\nExiting...Thank you!");
                        break;
                    default:
                        System.out.println("\nInvalid option! Please try again...");
                }
            }
        } else {
            throw new IllegalArgumentException("Enter a valid 4-digit PIN. \n");
        }

        sc.close();
    }
}

