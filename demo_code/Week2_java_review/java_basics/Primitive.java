/**
 * Some simple function examples in Java.
 * 
 * @author Sean Barker
 */
public class Primitive {
    
    /**
     * Get the form of water at the given temperature.
     *
     * @param temp A temperature of water.
     * @return Whether water at the given temp is solid, liquid, or gas.
     */
    public static String waterType(double temp) {
        if (temp < 32) {
            return "solid";
        } else if (temp < 212) {
            return "liquid";
        } else {
            return "gas";
        }
    }

    /**
     * Computes the sum of two numbers.
     * 
     * @param num1 The first number to add.
     * @param num2 The second number to add.
     * @return The sum of the two numbers.
     */
    public static int addTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }
    

    /**
     * Tests if a number is positive.
     *
     * @param num The number to test.
     * @return Whether the number is positive.
     */
    public static boolean isPositive(int num) {
        return num > 0;
    }
    
    
    /**
     * Given a number, print out three times the number.
     * Does not return anything (i.e. a procedure-style function).
     *
     * @param num The given value.
     */
    public static void printThreeTimes(int num) {
        System.out.println(num * 3);
    }
    
    /**
     * Tests the functions.
     */
    public static void main(String[] args) {
        printThreeTimes(50);
        int result = addTwoNumbers(5, 23);
        boolean test = isPositive(5);
        String form = waterType(83.2);
        // ... print results, etc ...
    }
    
}
