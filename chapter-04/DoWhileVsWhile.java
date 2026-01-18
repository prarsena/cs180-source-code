import java.util.Scanner;

public class DoWhileVsWhile{
    public static void main(String[] args) {
        
        Scanner kbd = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Press 1 to load data.");
            System.out.println("Press 3 to quit.");
            System.out.println("Enter a choice: ");
            choice = kbd.nextInt();            
            System.out.println("You are in the while loop");
        } while (choice != 3);

        kbd.close();

    }
}