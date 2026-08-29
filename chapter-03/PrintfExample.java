public class PrintfExample {
    public static void main(String[] args) {
        // Show how printf and String.format can format output.
        String name = "Sarah";
        int age = 33;
        //double gpa = 3.76;
        String school = "Bentley";
        double salary = 5414987123.8924129;
        System.out.println("Name: " + name + " School: " + school);
        System.out.printf("Name: %s Salary: %,.2f", name, age, salary);

        String formattedOutput = String.format("Name: %s Salary: %,.2f", name, age, salary);
        System.out.printf(formattedOutput);

    }
}
