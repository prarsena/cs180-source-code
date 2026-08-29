public class CustomMethod{
    // Print a house address with a color.
    public static void displayHouse(String color, int address, String streetname){
        System.out.println(address + " " + streetname + " is " + color);
    }

    public static void greeting(){
        System.out.println("Hello");
    }

    // Return a pass/fail message based on score.
    public static String evaluateGrade(int score){
        if (score >= 60){
            return "You pass";
        } else {
            return "You fail";
        }
    }

    // Return the square of a number.
    public static int squareNumber(int number){
        int numberSquared = number * number;
        return numberSquared;
    }

    public static void calculateFinalGrade(double score1, double score2){
        double scoreAverage = (score1 + score2)/2;
        System.out.println(scoreAverage);
    }

    public static void main(String[] args) {
        // Use the custom methods to demonstrate calling code.
        int originalNumber = 185;
        System.out.println(originalNumber);

        int squared = squareNumber(originalNumber);
        System.out.println(squared);

        System.out.println(originalNumber);
    }

}