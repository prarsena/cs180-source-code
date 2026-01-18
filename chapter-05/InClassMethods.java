import java.io.*;
import java.util.*;

public class InClassMethods {
    public static void main(String[] args) throws IOException {
        // primitives 
        int n = 62;
        double l = 4.99;
        char grade = 'A';
        boolean isFun = true;
        // objects 
        String msg = new String("Welcome, Gerald");
        Random s = new Random();
        File f = new File("members.txt");
        
        // AN OBJECT IS AN INSTANCE OF A CLASS. 
        Random r = new Random();
        // CLASSES AND OBJECTS HAVE METHODS. 
        r.nextInt(0,100);

        

        Scanner kbd = new Scanner(System.in);
        Scanner readFile = new Scanner(f);
        // object methods
        System.out.println(msg.concat(" to Java class."));
        char result = msg.charAt(0);
        String newMsg = msg.replace("Welcome", "Goodbye");
        
    }
}
