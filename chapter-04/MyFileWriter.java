import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    public static void main(String[] args) throws IOException {
        
        String filename = System.getProperty("user.home") + 
            "OneDrive - Bentley University/names.txt";
        FileWriter fw = new FileWriter(filename, true);
    }
}
