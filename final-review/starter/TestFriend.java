package starter;
import java.io.*;
import java.util.*;

public class TestFriend {

    public static Friend[] createFriends(){
        Friend m = new Friend();
        m.setName("Moflin");
        m.setAge(999);
        Friend a = new Friend("Andy", 22);
        Friend b = new Friend("Barry", 18);
        Friend c = new Friend("Clancy", 19);
        Friend d = new Friend("Diana", 20);
        Friend e = new Friend("Eileen", 19);
        Friend f = new Friend("Francis", 23);
        Friend g = new Friend("Gerald", 45);
        Friend h = new Friend("Helga", 26);
        Friend i = new Friend("Ingrid", 21);
        
        Friend[] friends = {a, b, c, d, e, f, g, h, i, m};
        return friends;
    }

    public static char optionsMenu(Scanner kbd){
        char choice;
        int count = 0;
        do {
            count++;
            if (count > 1 ){
                System.out.println("LET'S TRY THIS AGAIN.");
            }
            System.out.println("\nPROGRAM OPTIONS");
            System.out.println("- [V]iew profile     - [A]dd friend");
            System.out.println("- [W]rite to file    - [R]ead from file      - [Q]uit");
            System.out.print("Enter choice: ");
            choice = kbd.next().toUpperCase().charAt(0);
        } while ( choice!='V' && choice!='A' && choice!='W' && choice!='R' && choice!='Q' );
        
        return choice;
    }

    public static void main(String[] args) throws IOException {
        // Create initial Friend objects Array:
        final Friend[] friends = createFriends();

        // Convert friends Array to users ArrayList
        ArrayList<Friend> users = new ArrayList<>();
        for (Friend f : friends){
            users.add(f);
        }

        System.out.println("Welcome to FriendNet!!! \nThe friendliest place on the net.");
        Scanner kbd = new Scanner(System.in);

        //System.out.print("What is your name? ");
        //String name = kbd.nextLine();
        //System.out.print("How old are you? ");
        //int age = kbd.nextInt();
        String name = "ENTER YOUR NAME";
        int age = 99; // ENTER YOUR AGE

        Friend myAccount = new Friend(name, age);
        System.out.printf("%nWelcome, %s! %n", myAccount.getName());
        

        
        System.out.printf("\nGoodbye for now, %s!!%n", myAccount.getName());
        kbd.close();
    }
}
