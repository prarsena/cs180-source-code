import java.io.*;
import java.util.Scanner;

public class CreatePasswordFile {
    public static void main(String[] args) throws IOException {
        // Collect usernames and passwords from the user and save them to a file.
        FileWriter fwriter = new FileWriter("UserData.txt", true);
        PrintWriter outputFile = new PrintWriter(fwriter);
        Scanner kbd = new Scanner(System.in);
        boolean addMoreUsers = true;

        while (addMoreUsers){
            System.out.print("Enter the username: ");
            String username = kbd.next();

            System.out.print("Enter the password: ");
            String password = kbd.next();

            outputFile.printf("username: %10s | password: %10s %n", username, password);
            System.out.printf("Added %s. %nAdd another user? (Y/n) %n", username);
            if (kbd.next().toLowerCase().charAt(0) == 'n'){
                addMoreUsers = false;
            }
        }

        outputFile.close();
        kbd.close();
    }
}
