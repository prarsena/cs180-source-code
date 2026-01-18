public class LogicalNot {
    public static void main(String[] args) {
        
        boolean isLoggedIn = false;

        if(isLoggedIn){
            System.out.println("Welcome logged in user");
        } else {
            System.out.println("Please log in");
        }

        if(!isLoggedIn){
            System.out.println("Please log in");
        }


    }
}
