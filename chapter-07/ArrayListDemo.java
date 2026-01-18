import java.util.ArrayList; // Needed for ArrayList class

/**
   This program demonstrates an ArrayList.
*/

public class ArrayListDemo {
   public static void main(String[] args) {

      
      System.out.printf("%n*** %s %S ***%n%n", "ArrayList Demonstration", "(Mad Men Edition)");
      // Create an ArrayList to hold some names.
      ArrayList<String> nameList = new ArrayList<String>();
      
      // Add some names to the ArrayList.
      nameList.add("Don Draper");
      nameList.add("Betty Draper");
      nameList.add("Roger Sterling");
      nameList.add("Bert Cooper");
      
      // Display the size of the ArrayList.
      System.out.print("The ArrayList has " +
                         nameList.size() +
                         " objects stored in it: ");
      
      // The default toString method of ArrayLists:
      System.out.println(nameList);

      // Display the items in nameList using a for loop
      System.out.println("\nPrinting ArrayList using a for loop: ");
      for (int index = 0; index < nameList.size(); index++) {
         System.out.println(nameList.get(index));
      }

      // Display the items using an enhanced for loop
      System.out.println("\nPrinting ArrayList using an enhanced for loop (and a hyphen before the name): ");
      for (String name : nameList){
         System.out.println("- " + name);
      }

      // Remove the item at index 3.
      nameList.remove(3);

      System.out.println("\nWe remove Bert Cooper from Index 3 of the ArrayList (RIP). " +
                     "Here is the updated ArrayList:");

      // Display the items in nameList and their indices.
      for (int index = 0; index < nameList.size(); index++) {
         System.out.println("Index: " + index + " Name: " +
                            nameList.get(index));
      }

      // Insert an item at Index 0.
      nameList.add(0, "Peggy Olson");
      
      System.out.println("\nLet's add Peggy Olson to the first position in the ArrayList. " +
               "Here are the items now: ");         

      // Display the items in nameList and their indices.
      for (int index = 0; index < nameList.size(); index++) {
         System.out.println("Index: " + index + " Name: " +
                            nameList.get(index));
      }

      // Replace the item at Index 2
      nameList.set(2, "Megan Draper");

      System.out.println("\nLet's replace Betty Draper with Megan Draper. " +
                         "Here is the final version of the ArrayList: ");
                         
      // Display the items in nameList and their indices.
      for (int index = 0; index < nameList.size(); index++) {
         System.out.println("Index: " + index + " Name: " +
                            nameList.get(index));
      }      
      System.out.println("\n");
   }
}