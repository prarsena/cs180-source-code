import java.io.File;
import java.io.*;
import java.io.PrintWriter;
import java.util.Random;

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


        PrintWriter pw = new PrintWriter("xxx.txt");
        File f = new File("myFile.txt");
        Random r = new Random();
        String name = new String("Madison");
        
        System.out.println("\n\n\n\n");
        System.out.println(account);
        
    }
}
