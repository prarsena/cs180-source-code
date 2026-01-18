import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class AboutJava {
    public static void main(String[] args) {
        
        // Version javaEnv = Runtime.version();
        //System.out.println("Java Runtime Version: " + javaEnv + "\n\n");

        Properties p = System.getProperties();
        ArrayList<String> propElements = new ArrayList<String>();
        ArrayList<String> propKeys = new ArrayList<String>();

        for (Enumeration<Object> e = p.elements(); e.hasMoreElements();) {
            propElements.add(e.nextElement().toString());
        }

        for (Enumeration<Object> f = p.keys(); f.hasMoreElements();) {
            propKeys.add(f.nextElement().toString());
        }

        // for(int i=0;i<propElements.size();i++){
        //     System.out.println(propKeys.get(i) + " : " + propElements.get(i));
        // }

        //String javahome = p.getProperty("java.home");
        //String[] jhomePath = javahome.split("/");
        //String[] jdkProvider = jhomePath[6].split("-");

        //String l1 = jdkProvider[0] + " " + p.getProperty("java.version") + " " + p.getProperty("java.version.date");
        String l2 = p.getProperty("java.runtime.name") + " (build " + p.getProperty("java.runtime.version") + ") ";
        String l3 = p.getProperty("java.vm.name") + " (build " + p.getProperty("java.runtime.version") + ", " + p.getProperty("java.vm.info") + ") ";
        
        //String output = String.format("%s %n%s %n%s", l1, l2, l3);
        String output = String.format("%n%s %n%s", l2, l3);

        System.out.println(output);
    }
}
