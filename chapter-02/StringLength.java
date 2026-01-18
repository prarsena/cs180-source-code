// This program demonstrates the String class's length method.

public class StringLength {
   public static void main(String[] args) {
      String name = "Herman";
      int stringSize;
      String uppercaseName;

      stringSize = name.length();
      uppercaseName = name.toUpperCase();
      System.out.println(uppercaseName + " has " + stringSize +
                         " characters.");
   }
}
