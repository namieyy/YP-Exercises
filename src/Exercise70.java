import java.util.ArrayList;
import java.util.Scanner;

class BankAccount70{
    private long accountNumber;
    private double balance;
    private String ownerName;

    BankAccount70(long accountNumber, double balance, String ownerName){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void deposit (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit in: RM");
        double deposit = scanner.nextDouble();

        if(deposit > 0.1){
            this.balance = balance + deposit;
            System.out.println("\nSuccessfully deposited." +
                    "\nCurrent Balance: " + getBalance());
        } else {
            System.out.println("\nThe amount must be higher than 10 cents!");
        }
    }

    public void withdraw (){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nAvailable Balance: " + getBalance() +
                "\nEnter amount to withdraw: RM");
        double withdraw = scanner.nextDouble();
        if (withdraw < getBalance()){
            this.balance = balance - withdraw;
            System.out.println("\nSuccessfully withdraw." +
                    "\nCurrent balance: " + getBalance());
        } else {
            System.out.println("\nAmount exceed current balance!");
        }
    }

    public void checkBalance (){
        System.out.println("\nAccount No: " + getAccountNumber() +
                "\nOwner name: " + getOwnerName() +
                "\nCurrent balance: " + getBalance());
    }
}

class Customer70{
    private long customerId;
    private String name;
    private String email;
    private String phone;

    Customer70(long customerId, String name, String email, String phone){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;


    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void getCustomerDetail(){
        System.out.println("\nCustomer info" +
                "\nID: " + getCustomerId() +
                "\nName: " + getName() +
                "\nEmail: " + getEmail() +
                "\nPhone no: " + getPhone());
    }

    public void updateContactInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nOld Phone no: " + getPhone() +
                "\nEnter new Phone no: ");
        String newphone = scanner.next();
        this.phone = newphone;
        getCustomerDetail();
    }
}

class Bank70{
    ArrayList<BankAccount70> bankAcc = new ArrayList<>();
    ArrayList<Customer70> cust = new ArrayList<>();

    int bankIndex = 0;

    public void addAccount(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nAccount Field\nEnter account number: ");
        long accNo = scanner.nextLong();
        System.out.print("Balance: RM");
        double bal = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();

        BankAccount70 detail = new BankAccount70(accNo,bal,name);
        bankAcc.addFirst(detail);
    }

    public void addCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nCustomer Field\nCustomer ID: ");
        long id = scanner.nextLong();
        String name = bankAcc.get(bankIndex).getOwnerName();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Phone No: ");
        String phone = scanner.next();

        Customer70 detail = new Customer70(id,name,email,phone);
        cust.addFirst(detail);
    }

    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Bank Account: ");
        long acc = scanner.nextLong();
        System.out.print("Enter phone no: ");
        String phone = scanner.next();

        for (int i = 0; i < bankAcc.size(); i++){
            if (acc == bankAcc.get(i).getAccountNumber()){
                if (phone.equals(cust.get(i).getPhone()) ){
                    bankIndex = i;
                    System.out.println("\nLogin successful.");
                }
            } else {
                System.out.print("\nInvalid account no or phone no.");
            }
        }
    }

    public void action(){
        BankAccount70 bank01 = new BankAccount70(10010010, 2300, "Nazmi Ahmad");
        bankAcc.addFirst(bank01);
        Customer70 cust01 = new Customer70(10101010, "Nazmi Ahmad", "Nazmi@email.com", "0191010101");
        cust.addFirst(cust01);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n===== Welcome to Bank 70 =====");

        System.out.print("\n1 - Add Bank Account" +
                "\n2 - Login" +
                "\n0 - Exit" +
                "\n\nAction > ");
        int choice = scanner.nextInt();

        switch (choice){
            case 0:
                break;
            case 1:
                addAccount();
                addCustomer();
                bankAcc.get(bankIndex).checkBalance();
                cust.get(bankIndex).getCustomerDetail();
                break;
            case 2:
                login();
                break;
        }

        while (choice > 0){
            System.out.print("\n1 - Check balance" +
                    "\n2 - Deposit" +
                    "\n3 - Withdraw" +
                    "\n4 - User detail" +
                    "\n5 - Update phone no" +
                    "\n0 - Exit" +
                    "\n\nAction > ");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    break;
                case 1:
                    bankAcc.get(bankIndex).checkBalance();
                    break;
                case 2:
                    bankAcc.get(bankIndex).deposit();
                    break;
                case 3:
                    bankAcc.get(bankIndex).withdraw();
                    break;
                case 4:
                    cust.get(bankIndex).getCustomerDetail();
                    break;
                case 5:
                    cust.get(bankIndex).updateContactInfo();
                    break;
            }
        }
        System.out.println("\n===== Thank you for using Bank 70 =====");
    }
}

public class Exercise70 {
    public static void main(String[] args) {
        Bank70 bank70 = new Bank70();
        bank70.action();
    }
}
