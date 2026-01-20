import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentProgramCounterF25 {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> studentPrograms = new ArrayList<>();

        // Each inner ArrayList represents a student's studies
        studentPrograms.add(new ArrayList<String>() {{
            add("Actuarial Science - BS");
            add("Applied Statistics Minor");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Corporate Finance and Accounting - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Accounting - BS");
            add("Computer Information Systems Minor");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Experience Design Concentration");
            add("Information Design and Corporate Communication - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
            add("Corporate Finance and Accounting - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems Minor");
            add("Corporate Finance Concentration");
            add("Data Technologies Minor");
            add("Finance - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
            add("General Marketing Concentration");
            add("Marketing - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Undecided Business - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
            add("Corporate Finance and Accounting - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("International Affairs - BA");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("BS/BA-MSBA Joint Program");
            add("Computer Information Systems Minor");
            add("Data Analytics - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems Minor");
            add("Entrepreneurial Studies Concentration");
            add("Management - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
            add("Digital Marketing Concentration");
            add("Marketing - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems Minor");
            add("Corporate Finance and Accounting - BS");
            add("Honors Program");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems Minor");
            add("Corporate Finance and Accounting - BS");
            add("Philosophy Minor");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Finance - BS");
            add("General Finance Concentration");
            add("Law Minor");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems Minor");
            add("Creative Industries - BS");
            add("General Marketing Concentration");
            add("Marketing - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Finance - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Computer Information Systems - BS");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Accounting Minor");
            add("Finance - BS");
            add("General Finance Concentration");
        }});
        studentPrograms.add(new ArrayList<String>() {{
            add("Business Economics - BS");
            add("Management Concentration");
        }});
        
        // Example of accessing data
        //System.out.println("First student's program: " + studentPrograms.get(0));

        // Use a HashMap to store the counts of each degree type
        Map<String, Integer> degreeCounts = new HashMap<>();

        for (ArrayList<String> innerList : studentPrograms) {
            for (String program : innerList) {
                if (program.endsWith("- BS") || program.endsWith("- BA")) {
                    String degreeType = program.substring(0, program.length() - 5).trim();
                    degreeCounts.put(degreeType, degreeCounts.getOrDefault(degreeType, 0) + 1);
                }
            }
        }
        
        // Print the results in descending order by count
        System.out.println("Degree Counts:");
        // Find the max key length for formatting
        int maxKeyLen = degreeCounts.keySet().stream().mapToInt(String::length).max().orElse(0) + 5;
        degreeCounts.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .forEach(entry -> System.out.printf("%" + maxKeyLen + "s%d\n", entry.getKey() + ": ", entry.getValue()));
    }
}