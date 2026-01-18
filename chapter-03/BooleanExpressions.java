public class BooleanExpressions {
    public static void main(String[] args) {
        int x = 5;
        int y = 12;
        boolean isXGreaterThanY = x > y;

        if (isXGreaterThanY){
            System.out.println(x + "is greater than " + y);
        }

        if (y > x){
            System.out.println(y + "is greater than " + x);
        }

        boolean passingScore = false;
        double score = 72.5;

        if (score > 59.9) {
            passingScore = true;
        }

        // Some other code might be here...

        if (passingScore) {
            System.out.println("You can move onto the next course.");
        }
                
    }
}
