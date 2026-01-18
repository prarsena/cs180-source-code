public class IfStatements {
    public static void main(String[] args) {
        
        double gpa = 3.8; 
        boolean isHighAchiever = false;

        if (gpa > 3.0){
            isHighAchiever = true;
        } 

        if (isHighAchiever){
            System.out.println("Do you want to become an astronaut?");
        } else { 
            System.out.println("Just put the fries in bag bro.");
        }

    }
}
