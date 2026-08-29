import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PilferPasswords {
    public static void main(String[] args) throws IOException{
        // Read a file and print lines that include a password field.
        Scanner inputFile = new Scanner(new File("UserData.txt"));
        while (inputFile.hasNext()) {
            String str = inputFile.nextLine();
            if (str.contains("password")){
                System.out.println("Found password!!");
            }
            // Print out the line that contains the password:
            System.out.println(str);
        }
        inputFile.close();
    }
}
