import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public static void main(String[] args) {
        String fileName = "application.log";
        String logMessage = "INFO: Operation completed successfully.";

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("[%s] %s%n", timestamp, logMessage));
            System.out.println("Logged message to " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the log file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}