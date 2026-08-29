public class BreakLoop {
    public static void main(String[] args) {
        // Skip the number 5 while still looping through the rest.
        for (int i=0; i < 10; i++){
            if (i == 5){
                continue;
            }
            System.out.println(i);
        }


    }
}
