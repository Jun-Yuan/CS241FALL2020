import java.util.*;
import java.io.*;

public class ArrayListPractice {
   /*
    * Translation from array to ArrayList:
    *    String[] arr         ArrayList<String> list
    *    new String[n]        new ArrayList<String>()
    *    arr[i]               list.get(i)
    *    arr[i] = val         list.set(i, val)
    *    arr.length           list.size()
    *
    * New Operations:
    *    list.add(val)        appends the val to the list
    *    list.add(i, val)     inserts val at index i,
    *                         shifting subsequent values right
    *    list.remove(i)       removes and returns the value at i,
    *                         shifting subsequent values left
    *    list.clear()         empties the entire ArrayList
    *    list.indexOf(val)    returns the index of the first occurence
    *                         of the given value in the list
    */
   public static void main(String[] args) throws FileNotFoundException {
      ArrayList<String> list = new ArrayList<String>();
      list.add("You");
      list.add("are");
      list.add("my");
      list.add("fire");
      list.add("the");
      list.add("uh what was it?");
      list.add("desire");
      System.out.println(list);
      
      // Add "one" at index 5
      list.add(5, "one");
      
      // Remove "uh what was it?"
      list.remove(6);
      System.out.println(list);
      
      // There's useful methods that can find elements for you too!
      System.out.println(list.indexOf("fire"));
      
      // You can make ArrayList's of other types too! For primitives like ints
      // however, you need to use the "wrapper" class
      ArrayList<Integer> numbers = new ArrayList<Integer>();
      numbers.add(5);
      numbers.add(26);
      numbers.add(14);
      System.out.println(numbers);
   }
}