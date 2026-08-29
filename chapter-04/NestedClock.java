public class NestedClock {
    public static void main(String[] args) {
        // Nested loops print all hour-minute combinations for a clock.
        for (int hours = 1; hours <= 12; hours++){
            for (int minutes = 0; minutes < 60; minutes++){
                System.out.printf("%02d:%02d\n", hours, minutes);
            }
        }

    }
}
