public class NestedIfs {
    public static void main(String[] args) {
        int salary = 50_000;
        int yearsOnJob = 7;

        if (salary >= 40_000){
            System.out.println("Your salary meets the loan threshold.");
            
            if (yearsOnJob >= 3){
                System.out.println("You qualify for the loan.");
            } else{
                System.out.println("Not enough work experience.");
            }

        } else {
            System.out.println("You don't earn enough.");
        }

    }
}
