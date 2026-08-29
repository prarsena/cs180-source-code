import java.util.Scanner;

public class LoopsReview {
    public static void main(String[] args) {
        // Keep showing the menu until the user exits.
        int userChoice = 1;
        Scanner kbd = new Scanner(System.in);
        while (userChoice != 3){
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Exit");

            System.out.println("Enter your choice: ");
            userChoice = kbd.nextInt();
        }

        kbd.close();
    }
}
