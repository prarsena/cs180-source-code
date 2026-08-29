import java.lang.Runtime.Version;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class AboutJava {
    public static void main(String[] args) {
        // Print the title and the current Java runtime version.
        System.out.println("Java System Information".toUpperCase());
        Version javaEnv = Runtime.version();
        System.out.println("Java Runtime Version: " + javaEnv + "\n");

        // Retrieve all JVM/system properties and store their keys and values.
        Properties p = System.getProperties();
        ArrayList<String> propElements = new ArrayList<String>();
        ArrayList<String> propKeys = new ArrayList<String>();

        for (Enumeration<Object> e = p.elements(); e.hasMoreElements();) {
            propElements.add(e.nextElement().toString());
        }

        for (Enumeration<Object> f = p.keys(); f.hasMoreElements();) {
            propKeys.add(f.nextElement().toString());
        }

        // Display each Java system property and its value.
        System.out.println("System.GetProperties".toUpperCase());
        for(int i=0;i<propElements.size();i++){
            System.out.println(propKeys.get(i) + " : " + propElements.get(i));
        }

        // Extract information about the installed JDK from the java.home path.
        String javahome = p.getProperty("java.home");
        String[] jhomePath = javahome.split("/");
        String[] jdkProvider = jhomePath[6].split("-");

        // Build summary lines describing the Java version and VM details.
        String l1 = jdkProvider[0] + " " + p.getProperty("java.version") + " " + p.getProperty("java.version.date");
        String l2 = p.getProperty("java.runtime.name") + " (build " + p.getProperty("java.runtime.version") + ") ";
        String l3 = p.getProperty("java.vm.name") + " (build " + p.getProperty("java.runtime.version") + ", " + p.getProperty("java.vm.info") + ") ";
        
        // Print a formatted summary block with the Java environment details.
        System.out.println("\n");
        String output = String.format("%s %n%s %n%s", l1, l2, l3);
        System.out.println(output + "\n");
    }
}
