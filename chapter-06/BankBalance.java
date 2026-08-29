import java.util.Random;

public class BankBalance {
    private String name;
    private int id;
    private double balance;

    // A constructor that sets the name and ID.
    public BankBalance(String name, int id){
        this.name = name;
        this.id = id;
    }

    // A constructor that generates a random account ID.
    public BankBalance(String name){
        this.name = name;
        Random accountId = new Random();
        this.id = accountId.nextInt(1000,10000);
    }

    // Add money to the account balance.
    public void deposit(double money){
        this.balance += money;
    }

    // Remove money if enough funds exist.
    public void withdrawal(double money){
        if (money > this.balance){
            System.out.println("-----Transaction Cancelled. Insufficent Funds.");
        }
        else {
            this.balance -= money;
            System.out.println("-----Now dispensing $" + money );
        }

    }

    // Set the balance for the account.
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Get the current balance.
    public double getBalance() {
        return balance;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public static void printAccountInfo(BankBalance account){
        System.out.println("ID: " + account.getId() + " Name: " + account.getName());
        System.out.println("Current Balance: " + account.getBalance());
    }

    @Override
    public String toString(){
        return "ID: " + id + "\nName: " + name +
                "\nCurrent Balance: " + balance;
    }

}
