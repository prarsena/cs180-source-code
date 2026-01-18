import java.util.Random;

public class MyNotes {

    public static void greetUser(String name){
        System.out.println(name);
    }

    public static void greetUser(String name, String school){
        System.out.println("YOU ARE AWESOME");
    }

    public static void greetUser(String name, int grade){
        System.out.println("YOU ARE TERRIBLE");
    }

    public static void main(String[] args) {
        
        greetUser("Jason", "BU");
        greetUser("Jason", 14);

    }
}
