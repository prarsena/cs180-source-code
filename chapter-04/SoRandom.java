import java.util.Random;

public class SoRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        double num2 = rand.nextDouble();
        int randInt = rand.nextInt(1920, 2026);
        System.out.println(randInt);
        

        double rMath = Math.random();
        System.out.println(rMath); 

    }
}
