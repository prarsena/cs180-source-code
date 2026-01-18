public class CustomMethod{
    public static void displayHouse(String color, int address, String streetname){
        System.out.println(address + " " + streetname + " is " + color);
    }

    public static void greeting(){
        System.out.println("Hello");
    }

    public static String evaluateGrade(int score){
        if (score >= 60){
            return "You pass";
        } else {
            return "You fail";
        }
    }


    public static int squareNumber(int number){
        int numberSquared = number * number; 
        return numberSquared;
    }

    public static void calculateFinalGrade(double score1, double score2){
        double scoreAverage = (score1 + score2)/2;
        System.out.println(scoreAverage);
    }

    public static void main(String[] args) {
        
        // String gradeEval = evaluateGrade(99);
        // System.out.println(gradeEval);

        // System.out.println(evaluateGrade(52));

        int originalNumber = 185;
        System.out.println(originalNumber);

        int squared = squareNumber(originalNumber);
        System.out.println(squared);
        
        System.out.println(originalNumber);

        // CustomMethod.greeting();
        // Math.random();
        // displayHouse("white", 99, "Smith St");
        // String school = "Bentley";
        // school.replace("entley", "abson");
        // System.out.println();
    }

}