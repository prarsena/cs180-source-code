public class IfConditions {
    public static void main(String[] args) {
        // Simple if/else checks using a person's age.
        int age = 27;

        if (age < 21) System.out.println("You can't enter this bar.");
        else System.out.println("You may enter the bar.");

        if (age > 13) {
            System.out.println("You may watch PG-13 movies.");
            System.out.println("Hello");
        } else {
            System.out.println("You may only watch PG and G movies.");
        }

    }
    
}
