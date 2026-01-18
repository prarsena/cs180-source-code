public class Wrappers {
    public static void main(String[] args) {
        String s = "45";
        String t = "54";
        int num1 = Integer.parseInt(s);
        int num2 = Integer.parseInt(t);
        //double num3 = Double.parseDouble(t);
        
        int total; 
        total = num1 + num2;

        System.out.println(s + t);
        System.out.println(total);
    }
    
}
