import java.util.*;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("How many items do you want for Black Friday? ");
        int numberOfItems = kbd.nextInt();
        String[] items = new String[numberOfItems];

        for(int i=0; i<items.length; i++){
            System.out.println("Enter item #" + i + " that you want: ");
            items[i] = kbd.next(); 
        }

        System.out.println("Your Black Friday Wantlist: ");
        for(String item : items){
            System.out.println("- " + item);
        }
        kbd.close();
    }
}
