import java.util.Scanner;

public class RunningTotal {
    public static void main(String[] args) {
        // Keep a running total as the user enters numbers.
        int runningTotal = 0; // The accumulator, initialized to 0
        Scanner kbd = new Scanner(System.in);
        System.out.print("Type a number: ");
        while (kbd.hasNextInt()) {
            System.out.print("Type a number (or non-number to quit): ");
            int nextNumber = kbd.nextInt();
            runningTotal += nextNumber; // Using combined assignment operator
        }
        System.out.println("Total sum: " + runningTotal);
        kbd.close();
    }
}
