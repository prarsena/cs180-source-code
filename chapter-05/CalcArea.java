public class CalcArea {
    
    public static double calculateArea(double len, double width){
        return len * width;
    }
    
    public static void main(String[] args) {
        double len = 12;
        double wid = 25;
        double area = calculateArea(len, wid);
        System.out.println(area);
    }
}
