import java.util.*;

public class SearchDemo
{
    private MyTimer timer;

    public SearchDemo()
    {
        timer = new MyTimer();
    }
    
    public int linearSearch(int[] a, int key)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            if (a[i] == key)
                return i;
        }
        return -1;
    }
    
    public int binarySearch(int[] a, int key)
    {
        int lowIndex = 0;
        int highIndex = a.length - 1;
        while (lowIndex <= highIndex) 
        {
            int midIndex = (lowIndex + highIndex)/2;
            //System.out.println("low = " + lowIndex + "; high = " + highIndex + "; mid = " + midIndex);
            if (key < a[midIndex])
                highIndex = midIndex - 1;
            else if (key > a[midIndex])
                lowIndex = midIndex + 1;
            else  // found it!
                return midIndex;
        }
        return -1;
    }
    
    public void userValueSearch(int[] arr)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value to search for (-999 to end): ");
        int value = scanner.nextInt();
        while (value != -999)
        {
            int loc = binarySearch(arr, value);
            if (loc != -1)
                System.out.println("  binarySearch found it at location " + loc);
            else
                System.out.println("  not found...");
            loc = linearSearch(arr, value);
            if (loc != -1)
                System.out.println("  linearSearch found it at location " + loc);
            else
                System.out.println("  not found...");
            
            System.out.print("Enter value to search for (-999 to end): ");
            value = scanner.nextInt();
        }
    }
    
    public int binarySearchAllValues(int[] arr)
    {
        timer.startTiming();
        for (int value = 0; value < arr.length; value++)
        {
            int loc = binarySearch(arr, value);
        }
        timer.stopTiming();
        return timer.elapsedTime();
    }
    
    public double linearSearchAllValues(int[] arr)
    {
        timer.startTiming();
        for (int value = 0; value < arr.length; value++)
        {
            int loc = linearSearch(arr, value);
        }
        timer.stopTiming();
        return timer.elapsedSeconds();
    }
    
    public static void main(String[] args)
    {
        SearchDemo demo = new SearchDemo();
        int elapsedTime;
        double elapsedSec;
        
        // Get n from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array [try 100 thousand]: ");
        int n = scanner.nextInt();
        
        // Create a sorted array of size n
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i;
        
        // this method lets the user search for a particular value
        // with both binary & linear search
        demo.userValueSearch(arr);
        // this method searches for every value in the array
        // to better give a sense of time
        elapsedTime = demo.binarySearchAllValues(arr);
        System.out.println("Finished searching for all values with binary search.");
        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        System.out.println("Starting linear search...");
        double sec = demo.linearSearchAllValues(arr);
        System.out.println("Finished searching for all values with linear search.");
        System.out.println("Elapsed time: " + sec + " seconds");
    }
}