// A simple program demonstrating String objects.

public class StringDemo {
   public static void main(String[] args) {
      String greeting = "Good morning, ";
      String name = "Herman";
      // float myFloat = 5.75F;
      // double grosspay = 1_243.00;
      double sciDouble = 4.728197e4;
      double decimal = 100.99;
      int decCast = (int) decimal;
      System.out.println(decCast);

      System.out.println(greeting + name);
      System.out.println(sciDouble);
   }
}
