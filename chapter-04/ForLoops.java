public class ForLoops {
    public static void main(String[] args) {
        System.out.printf("%7s - %7s %n", "number", "n squared");
        for (int i=1; i <= 20; i++){
        	System.out.printf("%7d - %-7d %n", i, i*i);
        }
    }
}
