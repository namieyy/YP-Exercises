import java.util.ArrayList;
import java.util.Scanner;

class Account{
    private long accountId;
    private String accountHolderName;
    private double balance;
    private int pin;

    Account(){}

    Account(long accountId, String accountHolderName,double balance, int pin){
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    double deposit(double deposit){
        balance += deposit;
        return balance;
    }

    double withdraw(double withdraw){
        balance -= withdraw;
        return balance;
    }

}

class Bank1 extends Account{
    Scanner scanner = new Scanner(System.in);

    ArrayList<Account> acc = new ArrayList<>();

    int accountSelected = 0;

    Boolean idCorrect = false;

    public void addAccount(){
        System.out.println("\nAdd Account:-");
        System.out.print("Account ID: ");
        long accId = scanner.nextLong();
        System.out.print("Holder Name: ");
        String accHolderName = scanner.nextLine();
        double bal = 0.0;
        System.out.print("PIN: ");
        int pin = scanner.nextInt();

        Account account = new Account(accId,accHolderName,bal,pin);

        acc.addFirst(account);
        idCorrect = true;
    }

    public void viewDetail(){
        if(idCorrect){
            System.out.println("\nAccount ID: " + acc.get(accountSelected).getAccountId() +
                    "\nName: " + acc.get(accountSelected).getAccountHolderName() +
                    "\nBalance: " + acc.get(accountSelected).getBalance());
        }else {
            System.out.println("Invalid credential. Please re-login.");
        }

    }

    public void authenticate(){
        System.out.print("Enter ID: ");
        long tempId = scanner.nextLong();
        System.out.print("Enter PIN: ");
        int tempPin = scanner.nextInt();
        for(int i = 0; i < acc.size(); i++){
            if(tempId == acc.get(i).getAccountId() &&
            tempPin == acc.get(i).getPin()){
                accountSelected = i;
                idCorrect = true;
            }
        }
        if(idCorrect){
            viewDetail();
        }else {
            System.out.println("ID or PIN incorrect.");
        }
    }

    public void depositAcc(){
        if(idCorrect){
            System.out.print("\nEnter deposit amount: ");
            double deposit = scanner.nextDouble();
            if(deposit >= 0.1){
                acc.get(accountSelected).deposit(deposit);
                System.out.println("Successfully deposit: RM" + deposit);
                viewDetail();
            }
            else{
                System.out.println("The least amount to deposit is 10 cents.");
                viewDetail();
            }
        } else {
            System.out.println("Invalid credential. Please re-login.");
        }
    }

    public void withdrawAcc(){
        if(idCorrect){
            System.out.println("\nYour current balance: RM" + acc.get(accountSelected).getBalance());
            System.out.print("\nEnter withdraw amount: ");
            double withdraw = scanner.nextDouble();
            if(withdraw < acc.get(accountSelected).getBalance()){
                acc.get(accountSelected).withdraw(withdraw);
                System.out.println("Successfully withdraw: RM" + withdraw);
                viewDetail();
            }
            else{
                System.out.println("The amount you want exceeded your account balance.");
                viewDetail();
            }
        } else {
            System.out.println("Invalid credential. Please re-login.");
        }
    }

    public void action(){
        Account account1 = new Account(900800700,"Muhd Noor Nazmi",25765.87,123456);
        Account account2 = new Account(800700600,"Ahmad Ariff",900567.32,654321);
        acc.add(account1);
        acc.add(account2);

        System.out.println("\n=====Welcome to Nazmi Berjaya Bank =====");
        System.out.print("\n1 - Create new account" +
                "\n2 - Login" +
                "\n\nEnter your choice(in int): ");
        int signOption = scanner.nextInt();
        if (signOption == 1){
            addAccount();
        } else {
            authenticate();
        }

        int choice = 1;

        if(idCorrect) {
            while (choice > 0 && choice < 4) {
                System.out.print("\n1 - View Account" +
                        "\n2 - Deposit" +
                        "\n3 - Withdraw" +
                        "\n0 - Exit" +
                        "\n\nEnter your choice(in int): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        break;
                    case 1:
                        viewDetail();
                        break;
                    case 2:
                        depositAcc();
                        break;
                    case 3:
                        withdrawAcc();
                        break;
                }
            }
        }

        System.out.println("\n===== Thank you for using Nazmi Berjaya Bank. =====");
    }


}

public class Exercise64 {
    public static void main(String[] args) {
        Bank1 bank1 = new Bank1();
        bank1.action();

    }
}
