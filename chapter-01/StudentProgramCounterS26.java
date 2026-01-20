// Student Studies info Spring 2026
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentProgramCounterS26 {

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
                if (program.endsWith("BS")) {
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
        list.add(new ArrayList<>(Arrays.asList("Accounting Minor", "Data Analytics - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems - BS")));
        list.add(new ArrayList<>(Arrays.asList("Accounting - BS", "Data Analytics - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Digital Marketing Concentration", "International Affairs Minor", "Marketing - BS")));
        list.add(new ArrayList<>(Arrays.asList("Philosophy Minor", "Quantitative Economics - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("Economics-Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Finance - BS", "General Finance Concentration")));
        list.add(new ArrayList<>(Arrays.asList("Philosophy Minor", "Finance Minor", "Honors Program", "Information Technology in Accounting - BS")));
        list.add(new ArrayList<>(Arrays.asList("Corporate Finance Concentration", "Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("Undecided Business - BS")));
        list.add(new ArrayList<>(Arrays.asList("Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("Actuarial Science - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Honors Program")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Corporate Finance and Accounting - BS", "Accounting - BS", "Data Analytics - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Marketing - BS")));
        list.add(new ArrayList<>(Arrays.asList("Business Law - BS", "Computer Information Systems Minor", "Financial Services Concentration", "General Management Concentration", "Management - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Economics-Finance - BS")));
        list.add(new ArrayList<>(Arrays.asList("Artificial Intelligence for Innovation - BS", "Computer Information Systems - BS")));
        list.add(new ArrayList<>(Arrays.asList("Computer Information Systems Minor", "Corporate Finance and Accounting - BS", "Accounting Minor")));
        list.add(new ArrayList<>(Arrays.asList("Business Economics Minor", "Finance and Technology - BS")));
        list.add(new ArrayList<>(Arrays.asList("Capital Markets Concentration", "Finance - BS")));
    }
}