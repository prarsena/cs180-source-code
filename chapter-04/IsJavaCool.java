import java.util.Scanner;

public class IsJavaCool {
    public static void main(String[] args) {
        String msg = "Java is Cool.";
        boolean isJavaCool = true;
        Scanner kbd = new Scanner(System.in);
        int count = 1;
        while (isJavaCool){
            System.out.println(count + " " + msg);
            System.out.println("Do you agree? (y/N)");
            char answer = kbd.next().toLowerCase().charAt(0);
            if (answer == 'n'){
                isJavaCool = false;
            }
            count++;
        }
        kbd.close();
    }
}
