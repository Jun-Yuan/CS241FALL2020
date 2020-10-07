import java.util.List;
import java.util.ArrayList;

/**
 * A demo of working with Lists.
 * @author Sean Barker
 */
public class ListDemo {
 
    public static void arrayDemo() {
      String[] colleges = new String[3];
      colleges[0] = "Pace";
      colleges[1] = "CUNY";
      colleges[2] = "Fordham";
      colleges[2] = "NJIT"; // replaces Colby
      
      String name = colleges[1];
      System.out.println("college 1 is " + name);
      int count = colleges.length;
      System.out.println("array size is " + count);
    }
    
    public static void listDemo() {      
        List<String> colleges = new ArrayList<String>();
        colleges.add("Pace");
        colleges.add("CUNY");
        colleges.add("Fordham");
        colleges.set(2, "NJIT"); // replaces Colby

        String name = colleges.get(1);
        System.out.println("college 1 is " + name);
        int count = colleges.size();
        System.out.println("list size is " + count);
    }
    
    public static void main(String[] args) {
        System.out.println("Running array demo:");
        arrayDemo();
        System.out.println("Running list demo:");
        listDemo();
    }
    
}