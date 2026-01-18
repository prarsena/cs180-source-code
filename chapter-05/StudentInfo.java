import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        String studentName = getStudentName();
        double score = getStudentScore(studentName);
        char grade = calculateGrade(score);
        displayGradeReport(studentName, score, grade);
    }

    public static String getStudentName(){
        Scanner kbd = new Scanner(System.in);
        System.out.println("Type in your name: ");
        String name = kbd.nextLine();
        kbd.close();
        return name;
    }

    public static double getStudentScore(String studentName){
        double score; 
        if (studentName.equalsIgnoreCase("Jackson")){
            score = 88;
        }
        else if (studentName.equalsIgnoreCase("Molly")){
            score = 96;
        }
        else if (studentName.equalsIgnoreCase("Peter")){
            score = 52;
        }
        else {
            score = 82;
        }
        return score;
    }

    public static char calculateGrade(double score){
        char grade;
        if (score > 90){
            grade = 'A';
        } 
        else if (score > 80){
            grade = 'B';
        }
        else if (score > 70){
            grade = 'C';
        }
        else if (score > 60){
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        return grade;
    }

    public static void displayGradeReport(String studentName, double score, char grade){
        System.out.println("Student name: " + studentName);
        System.out.println("Student score: " + score);
        System.out.println("Student grade: " + grade);
    }
}
