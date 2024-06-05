package banking;

public class BankAccount {
    private String id;
    private String name;
    private double balance;
    private int transactionCount;

    public BankAccount(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited amount: " + amount + " current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (transactionCount == 3) {
            balance -= 5;
            transactionCount = 0;
        }
        if (balance < amount) {
            System.out.println("Not enough balance");
        } else {
            balance -= amount + 0.25;
            System.out.println("Withdrawn amount: " + amount + " current balance: " + balance);
        }
        transactionCount++;
    }
}

