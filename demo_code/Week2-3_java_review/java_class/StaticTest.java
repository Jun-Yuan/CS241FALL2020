/**
 * A simple demo of the static keyword.
 * 
 * @author Sean Barker
 */
public class StaticTest {
    
    /**
     * A regular (non-static) instance variable.
     * 
     * One copy exists per *instance* of the StaticTest class.
     */
    private int x = 0;
    
    /**
     * A static variable.
     * 
     * Exactly one copy exists regardless of the number
     * of instances of the StaticTest class (i.e., the variable
     * is associated with the class itself, not with any
     * specific instance of the class).
     */
    private static int y = 0;
    
    /**
     * Constructor - runs when a new StaticTest instance is created.
     */
    public StaticTest() {
        x++; // increments instance-specific x
        y++; // increments single y regardless of instance
        System.out.println("x is " + x);
        System.out.println("y is " + y);
    }
    
    
    /**
     * Create two StaticTest objects to demonstrate a static variable.
     */
    public static void main(String[] args) {
        StaticTest test1 = new StaticTest();
        StaticTest test2 = new StaticTest();
    }
    
}