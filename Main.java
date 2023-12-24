import java.util.*;

class BankAccount{
    private double Balance;

    public BankAccount(double initialBalance){
        this.Balance = initialBalance;
    }

    public double getBalance(){
        return Balance;
    }
    public void Deposit(double amount){
        if(amount > 0){
            Balance = Balance + amount;
            System.out.println("Deposit of Rs." + amount + " is Successful.");
        }
        else{
            System.out.println("Invalid Amount! Please Try Again.");
        }
    }

    public void Withdraw(double amount){
        if(amount > 0 && amount <= Balance){
            Balance = Balance - amount;
            System.out.println("Withdrawal of Rs." + amount+ " is Successful.");
        } else if (amount <= 0 ) {
            System.out.println("Invalid amount.Please Try Again");
        }else {
            System.out.println("Insufficient Funds!!");
        }
    }
}

class ATM{
    private final BankAccount bankAccount;
    Scanner sc = new Scanner(System.in);
    public ATM(BankAccount account){
        this.bankAccount = account;
    }
    public void Menu(){
        System.out.println("Welcome to OCOCI Bank ATM");
        System.out.println("1.Withdraw");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
    }

    public void Initialization() {
        int UserInput;
        do {
            Menu();
            System.out.println("Choose your service");
            UserInput = sc.nextInt();
            switch ((UserInput)) {
                case 1:
                    Withdraw();
                    break;
                case 2:
                    Deposit();
                    break;
                case 3:
                    CheckBalance();
                    break;
                case 4:
                    System.out.println("Thank You for Choosing our service.");
                    System.out.println("Your Convenient Banking Solution at Every Turn.");
                    System.out.println("------ OCOCI BANK ------");
                    break;
                default:
                    System.out.println("Invalid Input. Please Try Again!");
            }
        } while (UserInput != 4);
    }

        public void Withdraw() {
            System.out.println("Enter the amount to Withdraw: ");
            double amount = sc.nextDouble();
            bankAccount.Withdraw(amount);
        }
        private void Deposit(){
            System.out.println("Enter amount to Deposit:");
            double amount = sc.nextDouble();
            bankAccount.Deposit(amount);
        }
        private void CheckBalance(){
            System.out.println("Current Balance: Rs." + bankAccount.getBalance());
        }
}

public class Main{
    public static void main(String [] args){
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.Initialization();
    }
}