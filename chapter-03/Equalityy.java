import java.util.Scanner;

public class Equalityy {
    public static void main(String[] args) {
        
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter your name");
        String name = kbd.nextLine();

        // do this
        if (name.equalsIgnoreCase("sarah")){
            System.out.println("Names are equal");
        } else {
            System.out.println("Name is not equal");
        }


    }
}
