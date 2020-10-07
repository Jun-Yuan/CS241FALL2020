// The code below is relatively complete and has relatively good style
// Something to note is that this ArrayIntList will not expand in size
// if it runs out of capacity to store elements. This is something we will 
// discuss later in the quarter!

import javax.management.InstanceNotFoundException;

// Tyler Mi
// This class can store integers in a dynamically updating
// list, up to a certain capacity
public class ArrayIntList {
   private int [] elementData;
   private int size; //how many elements in ths list?
   public static final int DEFAULT_CAPACITY = 10;

    //constructor
   public ArrayIntList (int capacity) {
      elementData = new int[capacity];
      size = 0;
   }
   //default constructor
   public ArrayIntList() {
      elementData = new int[DEFAULT_CAPACITY];
      size = 0;
   }

   public int indexOf(int value) {
      int i = 0;
      while(i<size() && elementData[i] != value) {
         i++;
      }
      if(i==size()) {
         throw new ArrayIndexOutOfBoundsException("not found");
      } else
         return i;
   }

   public int size() {
      return size;
   }
   //precondition: 0 <= index < size?

   private boolean in_bound (int index) {
      return index>0 && index<size();
   }
   public int get(int index) {
      //if index is within bound
      //recall how we did get in linked list?  head->[] -> []->[target]
      if(in_bound(index)) {
         return elementData[index]; //how do we get index-th data from it?
      } else {
         throw new ArrayIndexOutOfBoundsException("out of bound");
      }
   }
   public void add(int value) {
      //today's focus: growable array list
      //if we have an infinitely long array
      //not in the postcondition: add to the head. so let us add to tail
      checkCapacityMayGrow(size+1);
      elementData[size]=value;
      size ++;
   }
   private void checkCapacityMayGrow(int neededCapacity) {
      //if neededCapacity is greater than the current capacity of array
      //then we instiante a shadow array twice as big as the current array
      //and copy the values from old array to new array
      //and make new array the member of this arrayList
      if(elementData.length < neededCapacity) {
         int [] standby = elementData;
         elementData = new int[elementData.length*2];
         for(int i=0; i<standby.length; i++) {
            elementData[i]=standby[i];
         }
         standby = null;
      }

   }
}
