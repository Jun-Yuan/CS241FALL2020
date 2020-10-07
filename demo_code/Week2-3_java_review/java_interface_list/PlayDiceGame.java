
/**
 * A simple game played with a Die.
 * 
 * @author Sean Barker
 */
public class PlayDiceGame {
    
    /**
     * Number of times to roll the die in a game.
     */
    private static final int NUM_ROLLS = 5;
    
    /**
     * Play a game with the given Die consisting of rolling the die
     * five times, resulting in a score of the total sum.
     * 
     * @param die The die to play the game with.
     * @return The final score of the game.
     */
    public static int playGame(Die die) {
        // roll the die five times
        int score = 0;
        for (int i = 0; i < NUM_ROLLS; i++) {
            die.roll();
            int dieRoll = die.getNumShowing();
            System.out.println("You rolled a " + dieRoll);
            score += dieRoll;
        }
        return score;
    }
    
    public static void main(String[] args) {
        Die myDie = new SixSidedDie(); // pick a Die, any die
        int myScore = playGame(myDie); // play the game with the Die
        System.out.println("My score was " + myScore);
        
    }

}