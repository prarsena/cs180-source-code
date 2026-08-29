public class BooleanLogic {
    // Return true if the score is high enough to pass.
    public static boolean isPassing(int score){
        return score > 59;
    }

    public static void main(String[] args) {
        // Call the method and print a message if the student passes.
        int score = 61;
        if(isPassing(score)){
            System.out.println("You passed.");
        }
    }
}
