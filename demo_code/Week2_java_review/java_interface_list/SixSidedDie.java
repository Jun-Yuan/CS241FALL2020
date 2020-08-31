import java.util.Random;

/**
 * An implementation of the Die interface.
 */
public class SixSidedDie implements Die {
    
    private static final int NUM_SIDES = 6;
    
    private Random generator;
    
    private int top;
    
    public SixSidedDie() {
        generator = new Random();
        this.roll();
    }
    
    public void roll() {
        top = generator.nextInt(NUM_SIDES) + 1;
    }
    
    public int getNumShowing() {
        return top;
    }
    
}