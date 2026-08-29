import java.io.*;
import java.util.Scanner;

public class TryReadWithResources {
    public static void main(String[] args) throws FileNotFoundException{
        // Read a file using try-with-resources so it closes automatically.
        int currentLine = 1;
        try (Scanner inputFile = new Scanner(new File("MusicArtists.txt"))){
            while(inputFile.hasNext()){
                String str = inputFile.nextLine();
                System.out.printf("%-5d %s %n", currentLine, str);
                currentLine++;
            }
        }
    }
}