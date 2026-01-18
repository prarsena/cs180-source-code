import java.io.*;
import java.util.*;

public class RandomClasses {
    
    public static void main(String[] args) throws IOException {
        
        Random randomNumber = new Random();
        IO.println(randomNumber);
        //Scanner kbd = new Scanner(System.in);
        File quotesFile = new File("quotes.txt");
        Scanner inputFile = new Scanner(quotesFile);
        IO.println(inputFile.next());

        String name = "Nancy";
        String name2 = new String("Name");
        IO.println(name);
        IO.println(name2);

        inputFile.close();
    }
}
