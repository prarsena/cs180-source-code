public class ElectedOffice {
    public static void main(String[] args) {
        
        int age = 40;
        boolean isUSCitizen = true;
        boolean isUSBorn = false;
        
        if (age >= 35){
            System.out.println("You meet the age req for President.");
            if (isUSBorn){
                System.out.println("You could President");
            } else {
                System.out.println("You can't be president");
            }
        }
        else {
            System.out.println("You don't meet the age req for Pres.");
        }
        if ((age >= 30) && (isUSCitizen)){
            System.out.println("You could run for senator");
        }
        else {
            System.out.println("You don't meet the age req for Sentator.");
        }
    }
}
