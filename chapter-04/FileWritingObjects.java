import java.io.*;
import java.util.Scanner;

public class FileWritingObjects {
    public static void main(String[] args) throws IOException {
        
        FileWriter fw = new FileWriter("movies.txt", false);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Home Alone");
        pw.println("Limitless");
        pw.println("Interstellar");
        pw.println("Friday");
        pw.println("Oppenheimer");
        pw.println("Barbie");
        pw.println("Weapons");

        pw.close();

        File f = new File("movies.txt");
        Scanner movies = new Scanner(f);

        while (movies.hasNext()){
            String movie = movies.nextLine();
            System.out.println(movie);
        }

        movies.close();
    }
}
