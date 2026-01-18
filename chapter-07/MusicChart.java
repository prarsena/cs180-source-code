public class MusicChart {
    /**
     * Accepts an array reference of integer scores and increases each score by 10.
     * @param scores The array of popularity scores.
     */
    public static void applyBonus(int[] scores) {
        System.out.println("\n--- Applying Score Bonus ---");
        // We iterate through the array directly using the reference
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + 10; // Increase each score by 10 points
        }
        System.out.println("--- Bonus Applied ---");
    }

    public static void main(String[] args) {
        // Scores for Artist 1, Artist 2, Artist 3, and Artist 4
        int[] artistScores = {55, 72, 88, 61};

        System.out.println(artistScores);

        System.out.print("Scores Before Bonus: ");
        // Print using an enhanced loop to demonstrate initial values
        for (int score : artistScores) {
            System.out.print(score + " ");
        }

        // Pass the array reference to the method
        applyBonus(artistScores);

        System.out.print("Scores After Bonus: ");
        // Print again. The original array has been permanently modified.
        // Output: 65 82 98 71
        for (int score : artistScores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}