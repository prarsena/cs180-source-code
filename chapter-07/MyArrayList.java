import java.util.ArrayList;

public class MyArrayList {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<>();
        items.add("milk");
        items.add("water");
        items.add("eggs");

        items.remove(0);

        for (String item : items){
            System.out.println(item);
        }
    }
}
