import java.util.Scanner;
import java.util.Random;
import java.io.File;
/**
 * Demonstrates topics needed for the course: arrays, Scanners, and random numbers.
 * 
 * @author Sean Barker
 */
public class MiscTopics {
    
    /**
     * Given an array of ints, return a new array
     * containing all the values squared.
     * 
     * @param values The values to square.
     * @return The new (squared) array.
     */
    public static int[] squareArray(int[] values) {
        int[] squared = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            squared[i] = values[i] * values[i];
        }
        return squared;
    }
    
    /**
     * Entry function to the program.
     */
    public static void main(String[] args) {
       
       // create a new array with 4 spaces
       int[] grades = new int[4];
       
       // assign some values
       grades[0] = 80;
       grades[1] = 90;
       grades[2] = 100;
       grades[3] = 85;
       
       System.out.println("grade at index 0 is " + grades[0]);
       
       int numGrades = grades.length;
       System.out.println("number of grades is " + numGrades);

       ///////////////////////////////////////////// 
       
       // make a random number generator
       Random generator = new Random();
        
       // get two random numbers from 0 (inclusive) to 100 (exclusive)
       int randInt1 = generator.nextInt(100);
       int randInt2 = generator.nextInt(100);
       System.out.println("ints are: " + randInt1 + ", " + randInt2);
        
       /////////////////////////////////////////////
       
       // make a scanner to read user input
       // make a scanner to read from a file
//	try {
  //     Scanner scan = new Scanner(new File("./test.dat"));
       Scanner scan = new Scanner(System.in);

       System.out.println("Enter a word: ");
       String word = scan.next(); // read a word that was entered
       System.out.println("You entered: " + word);
        
       System.out.println("Enter two numbers: ");
       int num1 = scan.nextInt(); // read a number that was entered
       int num2 = scan.nextInt(); // read another number
       System.out.println("Entered numbers are " + num1 + " and " + num2);
//	} catch (Exception e) {
//	}

    }
    
}
