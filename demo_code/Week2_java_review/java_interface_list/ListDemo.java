import java.util.List;
import java.util.ArrayList;

/**
 * A demo of working with Lists.
 * @author Sean Barker
 */
public class ListDemo {
 
    public static void arrayDemo() {
      String[] colleges = new String[3];
      colleges[0] = "Bowdoin";
      colleges[1] = "Bates";
      colleges[2] = "Colby";
      colleges[2] = "Williams"; // replaces Colby
      
      String name = colleges[1];
      System.out.println("college 1 is " + name);
      int count = colleges.length;
      System.out.println("array size is " + count);
    }
    
    public static void listDemo() {      
        List<String> colleges = new ArrayList<String>();
        colleges.add("Bowdoin");
        colleges.add("Bates");
        colleges.add("Colby");
        colleges.set(2, "Williams"); // replaces Colby

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