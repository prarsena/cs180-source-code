public class ModernSwitch {
    public static void main(String[] args) {
        // Use switch expressions to map values to labels.
        int month = 1;
        String monthName = switch(month){
            case 1 -> "January";
            case 2 -> "February";
            default -> "Some other month";
        };
        System.out.println("You were born in " + monthName);


        month = 9;
        String quarterName = switch(month){
            case 1, 2, 3 -> "Q1";
            case 4, 5, 6 -> "Q2";
            case 7, 8, 9 -> "Q3";
            case 10, 11, 12 -> "Q4";
            default -> "INVALID MONTH";
        };
        System.out.println("That month is in " + quarterName);


        char userInput = 'Q';
        switch(userInput){
            case 'A' -> System.out.println("You entered A");
            case 'S' -> System.out.println("Open Settings");
            case 'Q' -> System.out.println("Quit the program");
            default -> System.out.println("Invalid key");
        }


    }
}
