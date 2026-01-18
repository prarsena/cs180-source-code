import java.io.*;

public class TestBankBalance {
    public static void main(String[] args) throws IOException {
        BankBalance account = new BankBalance("Freddie Mercury");
        account.setBalance(120_438.23);
        account.deposit(432_123.33);
        System.out.println(account);

        System.out.println("---");
        
        BankBalance johnsAccount = new BankBalance("John Smith", 1999);
        johnsAccount.setBalance(200);
        System.out.println(johnsAccount);
        
        System.out.println("\n\n\n\n");
        System.out.println(account);
    }
}
