/*
 * a class that facilitates timing
 * program/method exectution (in milliseconds)
 */
public class MyTimer
{
    private long startTime, endTime;
    
    public void startTiming() {
        startTime = System.currentTimeMillis();
    }
    
    public void stopTiming() {
        endTime = System.currentTimeMillis();
    }
    
    public int elapsedTime() {
        return (int)(endTime - startTime);
    }
    
    public double elapsedSeconds() {
        return (double)(endTime - startTime)/1000;
    }
}