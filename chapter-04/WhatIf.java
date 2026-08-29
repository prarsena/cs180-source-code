import java.util.Scanner;

public class WhatIf {
    public static void main(String[] args) {
        // Ask the user whether to enter a custom name or use defaults.
        Scanner kbd = new Scanner(System.in);

        String fname = "Default-First-Name";
        String lname;
        char choice;

        System.out.println("Do you want to enter your name? (Y/n)");
        choice = kbd.next().toLowerCase().charAt(0);
        if (choice == 'y'){
            System.out.print("Enter your first name: ");
            fname = kbd.next();
            System.out.printf("Enter your last name: ");
            lname = kbd.next();
        }
        else {
            lname = "Default-Last-Name";
        }

        System.out.printf("Hello %s %s %n", fname, lname);
        kbd.close();
    }
}
