/**
   This program uses nested loops to simulate a clock.
*/

public class Clock {
   public static void main(String[] args){
      // The outside loop manages the hours on the clock.
      for (int hours = 1; hours <= 12; hours++){
          for (int minutes = 0; minutes <= 59; minutes++){
             for (int seconds = 0; seconds <= 59; seconds++){
                System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds); 
             }
          }
       }

      // The outside loop manages the hours on the clock.
      // When the loop initializes: hours = 1. 
      // Then Java looks to execute whatever statement is inside the loop..
      for (int hours = 1; hours <= 12; hours++){

         // The statement is another for loop, which initializes: minutes = 0.  
         for (int minutes = 0; minutes <= 59; minutes++){

               // The inner for loop now executes the print statement
               // and proceeds until the false condition is met (when minutes == 59).
               System.out.printf("%02d:%02d\n", hours, minutes); 
         }
      }
   }
}