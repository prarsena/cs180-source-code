public class CalcArea {
    // A method that calculates the area of a rectangle.
    public static double calculateArea(double len, double width){
        return len * width;
    }

    public static void main(String[] args) {
        // Use the method with a length and width.
        double len = 12;
        double wid = 25;
        double area = calculateArea(len, wid);
        System.out.println(area);
    }
}
