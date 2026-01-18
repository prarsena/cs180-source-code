import java.io.*;  
import java.util.Scanner;  
  
public class TryReadWithResources {  
    public static void main(String[] args) throws FileNotFoundException{
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