public class BooleanLogic {

    public static boolean isPassing(int score){
        return score > 59;
    }

    public static void main(String[] args) {

        int score = 61;
        if(isPassing(score)){
            System.out.println("You passed.");
        }
    }
}
