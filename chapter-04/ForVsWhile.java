public class ForVsWhile {
    public static void main(String[] args) {
        // Compare a for loop with a while loop.
        System.out.println("FOR LOOP");
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }

        System.out.println("WHILE LOOP");
        int count = 0;
        while(count < 10){
            System.out.println(count);
        }
    }
}
