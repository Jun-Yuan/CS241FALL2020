import java.util.*;

public class ArrayIntListClient {
   public static void main(String[] args) {
      // We'd like to be able to "implement" ArrayList such that 
      // our we can raplce ArrayList<Integer> with ArrayIntList
      // and still call the same methods for the same behavior!
      /*
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(5);
      list.add(42);
      list.add(96);
      System.out.println(list.size());      
      System.out.println(list.get(0));
      System.out.println(list.indexOf(42));
      */     
      
      // Initially, we had our fields not be private, which meant that
      // clients of our code could change the fields directly. This is not
      // something we ever want as they could set fields to something that
      // doesn't make sense, such as "list.size = -1"!
      /*
      ArrayIntList list = new ArrayIntList();
      list.elementData = new int[10];
      
      list.elementData[0] = 5
      list.size = 1;
      list.elementData[1] = 42;
      list.size = 2;
      list.elementData[2] = 96;
      list.size = 3;
      */
      
      ArrayIntList list = new ArrayIntList();
      list.add(5);
      list.add(42);
      list.add(96);
      list.add(96);

      System.out.println(list.size());
      System.out.println(list.indexOf(42));
   }
}