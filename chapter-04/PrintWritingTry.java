import java.io.PrintWriter;

public class PrintWritingTry {
    public static void main(String[] args) {
        // Try to write a few names to a file and handle errors if needed.
        try {
            PrintWriter outputFile = new PrintWriter("");
            outputFile.println("Carrie");
            outputFile.println("Donnie");
            outputFile.println("Mike");
            outputFile.close();
        } catch (Exception e){
            System.out.println("Can't write to this location \n" + e );
        }
    }
}
