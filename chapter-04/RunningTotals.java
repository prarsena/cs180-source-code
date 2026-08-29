import java.util.Scanner;

public class RunningTotals {
    public static void main(String[] args) {
        // Add up sales for each quarter of the year.
        int total = 0;
        Scanner kbd = new Scanner(System.in);
        for (int i=1; i < 5; i++){
            System.out.println("Enter the sales figures for Q" + i + ": ");
            int sales = kbd.nextInt();
            total += sales;
        }
        System.out.println("Yearly total: " + total);
        kbd.close();
    }
}
