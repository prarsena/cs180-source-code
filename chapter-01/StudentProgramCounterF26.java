// Student Studies info Spring 2026
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentProgramCounterF26 {

    public static void main(String[] args) {
        // Data Structure: ArrayList of ArrayLists
        ArrayList<ArrayList<String>> students = new ArrayList<>();

        loadData(students);

        // Maps for each category
        Map<String, Integer> majorCounts = new HashMap<>();
        Map<String, Integer> minorCounts = new HashMap<>();
        Map<String, Integer> otherCounts = new HashMap<>();

        // Categorize and count
        for (ArrayList<String> programs : students) {
            for (String program : programs) {
                if (program.contains("BS")) {
                    majorCounts.put(program, majorCounts.getOrDefault(program, 0) + 1);
                } else if (program.endsWith("Minor")) {
                    minorCounts.put(program, minorCounts.getOrDefault(program, 0) + 1);
                } else {
                    otherCounts.put(program, otherCounts.getOrDefault(program, 0) + 1);
                }
            }
        }

        // Helper to sort and print
        java.util.function.BiConsumer<Map<String, Integer>, String> printSorted = (map, title) -> {
            System.out.println("==============================================");
            System.out.println(title);
            System.out.println("==============================================");
            System.out.printf("%-45s | %-5s%n", "Program Name", "Total");
            System.out.println("----------------------------------------------");
            map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%-45s | %-5d%n", e.getKey(), e.getValue()));
            System.out.println("==============================================");
        };

        printSorted.accept(majorCounts, "STUDENT MAJORS TOTALS");
        printSorted.accept(minorCounts, "STUDENT MINORS TOTALS");
        printSorted.accept(otherCounts, "OTHER PROGRAMS OF STUDY TOTALS");

        // Show results in a window
        showResultsInWindow(majorCounts, minorCounts, otherCounts);
    }

    // Display results in a Swing window
    private static void showResultsInWindow(Map<String, Integer> majorCounts, Map<String, Integer> minorCounts, Map<String, Integer> otherCounts) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("Student Programs Summary");
            javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();

            tabbedPane.addTab("Majors", createTablePanel(majorCounts, "Majors"));
            tabbedPane.addTab("Minors", createTablePanel(minorCounts, "Minors"));
            tabbedPane.addTab("Other Programs", createTablePanel(otherCounts, "Other Programs"));

            frame.getContentPane().add(tabbedPane);
            frame.setSize(1000, 600);
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Helper to create a JTable panel from a map
    private static javax.swing.JPanel createTablePanel(Map<String, Integer> map, String title) {
        String[] columnNames = {"Program Name", "Total"};
        java.util.List<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .toList();
        Object[][] data = new Object[sorted.size()][2];
        for (int i = 0; i < sorted.size(); i++) {
            data[i][0] = sorted.get(i).getKey();
            data[i][1] = sorted.get(i).getValue();
        }
        javax.swing.JTable table = new javax.swing.JTable(data, columnNames);
        table.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 20));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 26));
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(table);
        javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout());
        panel.add(scrollPane, java.awt.BorderLayout.CENTER);
        return panel;
    }

    private static void loadData(ArrayList<ArrayList<String>> list) {
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("BS-MSF Joint Program", "Business Administration Minor", "Computer Information Systems Minor", "Finance - BS", "General Finance Concentration - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems - BS")));
        list.add(new ArrayList<>(Arrays.asList("Accounting - BS", "Business Administration Minor", "Computer Information Systems Minor", "Finance Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems Minor", "Corporate Finance and Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Accounting - BS", "Business Administration Minor", "Finance Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems - BS")));
        list.add(new ArrayList<>(Arrays.asList("Accounting Minor", "Business Administration Minor", "Entrepreneurial Studies Minor", "Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Corporate Finance and Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Accounting - BS", "Business Administration Minor", "Computer Information Systems Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Finance - BS", "General Finance Concentration", "Human and Artificial Thinking Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems Minor", "General Marketing Concentration", "Marketing - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Earth, Environment, and Global Sustainability Minor", "Finance - BS", "Financial Planning Concentration", "Honors Program")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems - BS", "Law Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems Minor", "Corporate Finance and Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Finance and Technology - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems Minor", "Corporate Finance and Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Computer Information Systems - BS")));
        list.add(new ArrayList<>(Arrays.asList("BS-MSAC Joint Program", "Business Administration Minor", "Business Economics Minor", "Corporate Finance and Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Undecided Business - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Finance and Technology - BS", "Philosophy Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Administration Minor", "Capital Markets Concentration", "Computer Information Systems Minor", "Cybersecurity Minor", "Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("BS-MSF Joint Program", "Business Administration Minor", "Finance - BS", "Law Minor")));
    }
}