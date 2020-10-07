/**
 * Poking around in Java.
 * 
 * @author Sean Barker 
 */
public class StringTest {
    
    /**
     * An example constant -- the freezing point of water.
     */
    private static final double FREEZING_POINT = 32;
    
    /**
     * Boiling point of water.
     */
    private static final double BOILING_POINT = 212;
    
    /**
     * Get the form of water at the given temperature.
     *
     * @param temp A temperature of water.
     * @return Whether water at the given temp is solid, liquid, or gas.
     */
    public static String waterType(double temp) {
        if (temp < FREEZING_POINT) {
            return "solid";
        } else if (temp < BOILING_POINT) {
            return "liquid";
        } else {
            return "gas";
        }
    }
    
    /**
     * Return the first position of the given letter in the given word.
     * If the letter does not exist in the word, returns -1.
     * 
     * @param word The word to search.
     * @param letter The letter to search for.
     * @return The first position of the letter or -1.
     */
    public static int indexOfLetter(String word, char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                return i;
            }
        }
        return -1;
    }
    
    
    /**
     * Test the functions.
     */
    public static void main(String[] args) {

        // example of calling indexOfLetter
        String testWord = "Pace Wins";
        char testLetter = 'W';
        int position = indexOfLetter(testWord, testLetter);

        // equivalent using built-in String method
        int position2 = testWord.indexOf('W');

    }
    
}
