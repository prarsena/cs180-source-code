import java.util.Scanner;

public class Choices {
    public static void main(String[] args) {
        int choice;
        Scanner kbd = new Scanner(System.in);
        do {
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = kbd.nextInt();
            
            switch (choice) {
                case 1 -> System.out.println("You selected option 1.\n");
                case 2 -> System.out.println("You selected option 2.\n");
                case 3 -> System.out.println("Exiting...\n");
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 3);
        kbd.close();
    }
}
