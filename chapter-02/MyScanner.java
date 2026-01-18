import java.util.Scanner; // Required for Scanner

public class MyScanner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Initialize Scanner

        System.out.print("Enter your name: ");
        String name = keyboard.nextLine(); // Read a line of text

        System.out.print("Enter your age: ");
        int age = keyboard.nextInt(); // Read an integer

        System.out.print("Enter your GPA: ");
        double gpa = keyboard.nextDouble(); // Read a double

        System.out.println("Hello, " + name + "! You are " + age + " years old with a GPA of " + gpa);

        keyboard.close(); // It's good practice to close the scanner when done
    }
}