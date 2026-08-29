import java.util.Random;
import java.util.Scanner;

public class ObjectsExample {
    public static void main(String[] args) {
        // Read a number from the keyboard and create a random object.
        Scanner kbd = new Scanner(System.in);

        System.out.println("Enter the maximum boundary for a random number: ");
        int max = kbd.nextInt();

        Random rand = new Random();
        System.out.println("Generating a random number between 0 and " + max);
        System.out.println(rand.nextInt(0,max));

        kbd.close();
    }
}
