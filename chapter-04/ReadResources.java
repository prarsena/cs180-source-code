import java.io.*;
import java.util.Scanner;

public class ReadResources {
    public static void main(String[] args) throws IOException {
        // Read each line from a resource file and number it.
        int currentLine = 1;
        Scanner inputFile = new Scanner(new File("MusicArtists.txt"));
        while(inputFile.hasNext()){
            String str = inputFile.nextLine();
            System.out.printf("%-5d %s %n", currentLine, str);
            currentLine++;
        }
        inputFile.close();
    }
}
