import java.util.Scanner;

public class CandyCrewTest {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.printf("%20s %s %s %n", "-----", "Halloween Candy Crew Haul", "-----");
        System.out.print("Enter the Candy Crew size: ");
        int crewSize = kbd.nextInt();
        int candyCount = 0;
        int crewMember = 1;

        while (crewMember <= crewSize){
            System.out.printf("Enter the candy count for crew member %d: ", crewMember);
            int individualCandyContribution = kbd.nextInt();
            candyCount += individualCandyContribution;
            crewMember++;
        }


        System.out.printf("%20s %s %s %n", "-----", "Candy Calculations", "-----");
        System.out.printf("Total crew members: %d %n", crewSize);
        System.out.printf("Total candy count:  %d %n", candyCount);
        double averageCandyPieces = candyCount / crewSize;
        System.out.printf("Candy per crew member: %.0f %n", averageCandyPieces);
        double candyCost = 0.42;
        double cashEquivalence = candyCost * averageCandyPieces;
        System.out.printf("Retail value of candy per crew member: $%.2f %n", cashEquivalence);

        kbd.close();
    }
}
