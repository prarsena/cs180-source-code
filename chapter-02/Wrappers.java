public class Wrappers {
    public static void main(String[] args) {
        // Convert strings to numbers using wrapper methods.
        String s = "45";
        String t = "54";
        int num1 = Integer.parseInt(s);
        int num2 = Integer.parseInt(t);
        double num3 = Double.parseDouble(t);

        int total;
        total = num1 + num2;

        // Print the original strings, the sum, and the converted double.
        System.out.println(s + t);
        System.out.println(total);
        System.out.println(num3);
    }

}
