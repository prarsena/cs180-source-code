import java.util.Scanner;

/**
   This program translates the English names of
   the seasons into German.
*/
 
public class Seasons {
   public static void main(String[] args) {
      String input;
      
      // Create a Scanner object for keyboard input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get a day from the user.
      System.out.print("Enter the name of a season: ");
      input = keyboard.nextLine();
      
      // Translate the season to German.
      switch (input) {
         case "spring":
            System.out.println("der Frühling");
            break;
         case "summer":
            System.out.println("der Sommer");
            break;
         case "autumn":
         case "fall":
            System.out.println("der Herbst");
            break;
         case "winter":
            System.out.println("der Winter");
            break;
         default:
            System.out.println("Please enter one of these words:\n" +
                         "spring, summer, autumn, fall, or winter.");
      }
   }
}