public class Incrementor {
    public static void main(String[] args) {
        
        int a = 10;
        int b = 5 + a--;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
