class BankAccount{
    String accountNumber;
    double balance;
    String ownerName;

    BankAccount(){
        accountNumber = "8820-2777-25";
        balance = 109655.53;
        ownerName = "Nazmi Ahmad";
    }

    public double Deposit (double deposit){
        return this.balance += deposit;
    }

    public double Withdraw (double withdraw){
        if(withdraw > this.balance){
            System.out.println("\nWithdraw request exceeding balance!");
            return this.balance;
        }else{
            System.out.println("\nYou've successfull withdraw RM700.");
            return this.balance -= withdraw;
        }
    }

    public double getBalance (double balance){
        return balance;
    }

    public String getOwnerName (String ownerName){
        return ownerName;
    }

    public void ActionDisplay(){
        System.out.println("\nName: " + getOwnerName(ownerName) +
                "\nAcc No.: " + this.accountNumber +
                "\nBalance: RM" + this.getBalance(balance));
        Deposit(500);
        System.out.println("\nYou've successfull deposit RM500. \nCurrent Balance RM" +
                this.getBalance(balance));

        Withdraw(999999999);
        System.out.println("Current Balance RM" +
                this.getBalance(balance));

        Withdraw(700);
        System.out.println("Current Balance RM" +
                this.getBalance(balance));
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.ActionDisplay();
    }
}
