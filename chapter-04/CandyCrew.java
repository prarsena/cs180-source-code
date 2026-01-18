import java.util.Scanner;

public class CandyCrew {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String title = "Halloween Candy Crew Haul";
        System.out.printf("%s %s %s %n", "------", title, "-----");
        System.out.println("Enter the Candy Crew size: ");
        int crewSize = kbd.nextInt();
        int totalCandyCount = 0;
        for (int i=1; i <= crewSize; i++){
            System.out.printf("How much candy did crew member %d collect? ", i);
            int individualCandyCount = kbd.nextInt();
            totalCandyCount += individualCandyCount;
        }
        System.out.println("The Candy Crew Collected " + totalCandyCount + " pieces of candy.");
        int averageCandyPieces = totalCandyCount / crewSize;
        System.out.println("Each Crew member gets " + averageCandyPieces + " per person.");
        double candyCost = 0.25;
        double cashEquivalence = candyCost * averageCandyPieces;
        System.out.printf("Retail value of candy per crew member: $%,.2f", cashEquivalence);
        kbd.close();
    }
}
