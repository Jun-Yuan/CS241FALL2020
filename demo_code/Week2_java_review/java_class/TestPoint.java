/**
 * Wrapper class for a main function testing the Point class.
 * 
 * @author Sean Barker
 */
public class TestPoint {
     
    /**
     * Main function demonstrating the use of the Point class.
     */
    public static void main(String[] args) {
        
        Point p1 = new Point(3, 5);
        
        System.out.println("p1 is " + p1); // implicitly calls p1.toString()

        System.out.println("p1 x is " + p1.getX() + ", y is " + p1.getY());
        
        p1.setX(12); // change x value
        System.out.println("p1 updated x val is " + p1.getX());
        
        Point p2 = new Point(-2.3, 1);

        double distance = p1.distanceTo(p2);
        double originDistance = p1.distanceToOrigin();
        
        System.out.println("p1 to p2 dist is: " + distance);
        System.out.println("origin dist is: " + originDistance);
        
    }   
    
}