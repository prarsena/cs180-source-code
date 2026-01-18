public class LayeredMethods {
    public static void methodA(){
        System.out.println("\tStarting Method A...");
        methodB();
        System.out.println("\tFinishing Method A");
    }

    public static void methodB(){
        System.out.println("\t\tStarting Method B..");
        System.out.println("\t\tFinishing Method B..");
    }

    public static void main(String[] args) {
        System.out.println("Starting program...");
        methodA();
        System.out.println("Finishing  program.");
    }
}
