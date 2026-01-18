public class TerneryOperator {
    public static void main(String[] args) {

        //Consider this `if-else` block:
        int hours = 3;
        int billableHours;

        if (hours < 5) {
            billableHours = 5;
        } else {
            billableHours = hours;
        }
        
        System.out.println(billableHours); // 5

        //Using the ternary operator, 
        //the assignment can be written in a single line:
        int billableHoursT = (hours < 5) ? 5 : hours; 

        System.out.println(billableHoursT); // 5

    }
}
