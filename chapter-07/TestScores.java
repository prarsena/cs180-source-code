public class TestScores {

    public static void applyScale(int[] scores){
        for(int i=0; i < scores.length; i++){
            scores[i] += 7;
        }
    }

    public static void main(String[] args) {
        int[] scores = {87, 49, 91, 78, 23, 88, 33};
        
        applyScale(scores);
        applyScale(scores);

        for (int score : scores){
            System.out.print(score + ", ");
        }

    }
}
