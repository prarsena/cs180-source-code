public class NestedClock {
    public static void main(String[] args) {

        for (int hours = 1; hours <= 12; hours++){
            for (int minutes = 0; minutes < 60; minutes++){
                System.out.printf("%02d:%02d\n", hours, minutes); 
            }
        }

    }
}
