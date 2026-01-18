import java.io.*;  
public class CreateMusicArtistsFile {  
    public static void main(String[] args) throws IOException {
	
		PrintWriter outputFile = new PrintWriter("");
		outputFile.println("The Cure");  
		outputFile.println("The Smiths");  
		outputFile.println("Joy Division");  
		outputFile.println("Green Day");  
		outputFile.println("The The");  
		outputFile.println("The Beach Boys");  
		outputFile.println("Talking Heads");  
		outputFile.println("Neutral Milk Hotel");  
		outputFile.println("The Magnetic Fields");  
		outputFile.println("The Velvet Underground");  
		outputFile.close();
		
    }  
}