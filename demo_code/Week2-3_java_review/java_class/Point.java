/**
 * A class representing a 2D point. Allows the measurement
 * of distances between points.
 * 
 * @author Sean Barker
 */
public class Point {
    
    /**
     * X coordinate of the point.
     * Instance variables should always be private!
     */
    private double xCoord;
    
    /**
     * Y coordinate of the point.
     */
    private double yCoord;
    
    /**
     * Construct a new point with the given X and Y values.
     * 
     * @param xval The x coordinate.
     * @praam yval The y coordinate.
     */
    public Point(double xval, double yval) {
        // save the argument values into the instance variables
        
        xCoord = xval; // equivalent to this.xCoord = xval;
        yCoord = yval; // equivalent to this.yCoord = yval;
    }
    
    /**
     * Compute the distance from this point to another point.
     * 
     * @param otherPoint The other point to compare to
     * @return The distance from this point to otherPoint.
     */
    public double distanceTo(Point otherPoint) {
        double x1 = this.xCoord; // define some temporary (local) variables
        double y1 = this.yCoord;
        double x2 = otherPoint.xCoord;
        double y2 = otherPoint.yCoord;
        
        // compute the distance
        return Math.sqrt(square(x1 - x2) + square(y1 - y2));
    }
    
    /**
     * A helper (i.e., private) method to compute the square of a value.
     * 
     * @param val The value to square.
     * @return The squared value.
     */
    private double square(double val) {
        return val * val;
    }
    
    /**
     * Compute the distance from this point to the origin.
     * 
     * @return The distance from this point to (0, 0).
     */
    public double distanceToOrigin() {
        // construct a new object representing the origin
        Point origin = new Point(0, 0);
        
        // now use the existing distanceTo method to compute the distance
        // could also write origin.distanceTo(this);
        return distanceTo(origin); // equivalent to this.distanceTo(origin);
    }
    
    /**
     * Get the point's x value (a getter method).
     * 
     * @return The x coordinate.
     */
    public double getX() {
        return xCoord;
    }
    
    /**
     * Get the point's y value (a getter method).
     * 
     * @return The y coordinate.
     */
    public double getY() {
        return yCoord;
    }
    
    /**
     * Change the point's x value (a setter method).
     * 
     * @param newX The new x coordinate.
     */
    public void setX(double newX) {
        xCoord = newX;
    }
    
    /**
     * Change the point's y value (a setter method).
     * 
     * @param newY The new y coordinate.
     */
    public void setY(double newY) {
        yCoord = newY;
    }
    
    /**
     * Construct a string representation of the point object.
     * 
     * @return A string representation showing the point coordinates.
     */
    public String toString() {
        return "[" + xCoord + "," + yCoord + "]";
    }

    /**
     * Check whether this Point is equivalent to another object - 
     * a Point is equal to another Point if they have the same
     * X and Y coordinate values.
     *
     * @param obj The other object to compare against.
     * @return True if obj is equal to this point. 
     */
    public boolean equals(Object obj) {
      if (obj instanceof Point) {
        Point otherPoint = (Point) obj;
        double otherX = otherPoint.xCoord;
        double otherY = otherPoint.yCoord;
        return this.xCoord == otherX && this.yCoord == otherY;
      } else {
        return false;
      }
    }
    
    /**
     * Main function demonstrating the use of the Point class.
     */
    public static void main(String[] args) {
        
        Point p1 = new Point(3, 5);
        System.out.println("p1 is " + p1); // calls the toString method automatically
        
        System.out.println("p1 x val is " + p1.getX()); // read x value
        
        p1.setX(8.12); // change x value
        System.out.println("p1 updated x val is " + p1.getX());
        
        Point p2 = new Point(-2.3, 1);
        System.out.println("p2 is " + p2);
        
        double distance = p1.distanceTo(p2);
        double originDistance = p1.distanceToOrigin();
        
        System.out.println("p1 to p2 dist is: " + distance);
        System.out.println("origin dist is: " + originDistance);
        
    }
    
}
