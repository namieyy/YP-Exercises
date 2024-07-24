import java.util.Random;

class BankAccountWanAmrin {
    private String accountNumber;
    private String ownerName;
    private double balance;

    BankAccountWanAmrin(String name, double balance) {
        this.ownerName = name;
        this.balance = balance;

        generateAccountNumber();

        System.out.println("New account has been opened!");
        System.out.println("Owner: " + this.getOwnerName());
        System.out.println("Balance: " + this.getBalance());
        System.out.println("Account Number: " + this.accountNumber + "\n");
    }

    double getBalance () {
        return this.balance;
    }

    String getOwnerName () {
        return this.ownerName;
    }

    void deposit(double amount) {
        System.out.println("Depositing " + amount + "\n");
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Insufficient Balance!\n");
        } else {
            System.out.println("Withdrawing " + amount + "\n");
            this.balance -= amount;
        }
    }

    private void generateAccountNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        int min = 10000000;
        int max = 99999999;
        int number = random.nextInt(max - min + 1) + min;

        this.accountNumber = Integer.toString(number);
    }
}

public class Exercise28ByWanAmrin {
    public static void main(String[] args) {
        BankAccountWanAmrin account = new BankAccountWanAmrin("Amrin Jaffni", 100);
        System.out.println("Current balance: " + account.getBalance());

        account.deposit(153);
        System.out.println("Current balance: " + account.getBalance());

        ;
    }
}