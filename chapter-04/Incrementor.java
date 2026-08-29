public class Incrementor {
    public static void main(String[] args) {
        // Demonstrate post-decrement behavior with a variable.
        int a = 10;
        int b = 5 + a--;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}
