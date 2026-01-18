public class LoanExample{
    public static void main(String[] args) {
        
        // Program determines if an applicant meets two conditions 
        // to qualify for a loan. 
        double salary = 50000;
        int yearsOnJob = 3;

        if (salary >= 40000) {
            if (yearsOnJob >= 2) {
                System.out.println("You qualify for the loan.");
            } else {
                System.out.println("You must have been on your current job for at least two years.");
            }
        } else {
            System.out.println("You must earn at least $40,000 per year.");
        }
        
    }
}