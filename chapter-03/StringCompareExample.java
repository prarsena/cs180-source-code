public class StringCompareExample {
    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "Goodbye";

        // Correct way to compare strings for equality
        if (str1.equals(str2)) { // This is true
            System.out.println("str1 and str2 are equal.");
        }

        if (str1.equals(str3)) { // This is false
            System.out.println("str1 and str3 are equal.");
        } else {
            System.out.println("str1 and str3 are NOT equal.");
        }
        
        String username1 = "Admin";
        String username2 = "admin";

        if (username1.equalsIgnoreCase(username2)) { // This is true
            System.out.println("Usernames are the same, ignoring case.");
        }
        
    }
}
