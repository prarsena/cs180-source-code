import java.io.*;
import java.util.Scanner;

public class ReadFromFiles {
    public static void main(String[] args) throws IOException {
        // Read numbers from a file and add them together.

        File numbersFile = new File("Numbers.txt");
        Scanner numbersInput = new Scanner(numbersFile);

        double fileTotal = 0.0;

        while (numbersInput.hasNext()){
            double currentNumber = numbersInput.nextDouble();
            fileTotal += currentNumber;
            System.out.println(currentNumber);
        }

        System.out.println("File total: " + fileTotal);
        numbersInput.close();
    }
}
