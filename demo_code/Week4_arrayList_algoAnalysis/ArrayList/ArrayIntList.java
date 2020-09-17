// The code below is relatively complete and has relatively good style
// Something to note is that this ArrayIntList will not expand in size
// if it runs out of capacity to store elements. This is something we will 
// discuss later in the quarter!

// Tyler Mi
// This class can store integers in a dynamically updating
// list, up to a certain capacity
public class ArrayIntList {
   private int[] elementData;
   private int size;
   public static int DEFAULT_CAPACITY = 2;
   // Constructs an ArrayIntList with the default capacity
   public ArrayIntList() {
      this(DEFAULT_CAPACITY);
   }
   
   // Constructs an ArrayIntList of the given capacity
   public ArrayIntList(int capacity) {
      elementData = new int[capacity];
      size = 0;
   }
   
   // Appends the given value to the end of the ArrayIntList
   // @throws - IllegalStateException if this ArrayIntList does not have
   //           space for the value
   public void add(int value) {
      checkCapacityMayGrow(size + 1);
      elementData[size] = value;
      size++;
   }
   
   // Returns the number of elements in the ArrayIntList
   public int size() {
      return size;
   }
   
   // Returns the element at the given index
   // @throws - IndexOutOfBoundsException if the given index is greater or
   //           equal to size or less than 0
   public int get(int index) {
      checkIndex(index);
      return elementData[index];
   }
   
   // Returns the index of the first occurence of the given value
   // Returns -1 if the given value was not found in the ArrayIntList
   public int indexOf(int value) {
      for (int i = 0; i < size; i++) {
         if (elementData[i] == value) {
            return i;
         }
      }
      return -1;
   }
      
   // Returns true if the given value is contained within the ArrayIntList
   // and false otherwise
   public boolean contains(int value) {
      return indexOf(value) >= 0;
   }
   
   // Inserts the given value into the ArrayIntList at the given index,
   // shifting all values at that index and later indexes over one to the right
   // @throws - IndexOutOfBoundsException if the given index is greater than
   //           size or less than 0
   // @throws - IllegalStateException if this ArrayIntList does not have
   //           space for the value
   public void add(int index, int value) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Index " + index + 
               " is invalid for a list of size " + size);
      }
      checkCapacityMayGrow(size + 1);

      for (int i = size; i > index; i--) {
         elementData[i] = elementData[i - 1];
      }
      elementData[index] = value;
      size++;
   }
   
   // Adds all the values from the given ArrayIntList to the end of
   // this ArrayIntlist
   // @throws - IllegalStateException if this ArrayIntList does not have
   //           space for the values
   public void addAll(ArrayIntList other) {
      checkCapacityMayGrow(size + other.size);
      for (int i = 0; i < other.size; i++) {
         add(other.elementData[i]);
      }
   }
   
   // Modifies the element at the given index to be the given value
   // @throws - IndexOutOfBoundsException if the given index is greater or
   //           equal to size or less than 0
   public void set(int index, int value) {
      checkIndex(index);
      elementData[index] = value;
   }
   
   // Removes the element at the given index from the ArrayIntList, shifting all
   // subsequent values over one to the left
   // @throws - IndexOutOfBoundsException if the given index is greater or
   //           equal to size or less than 0
   public void remove(int index) {
      checkIndex(index);
      for(int i = index; i < size - 1; i++) {
         elementData[i] = elementData[i + 1];
      }
      size--;
   }
   
   // Clears the contents of the ArrayIntList so that it is empty
   public void clear() {
      size = 0;
   }
   
   // Returns a formatted String representing the contents of the ArrayIntList
   // eg. "[1, 526, 49]" 
   public String toString() {
      if (size == 0) {
         return "[]";
      } else {
         String result = "[" + elementData[0];
         for (int i = 1; i < size; i++) {
            result += ", " + elementData[i];
         }
         result += "]";
         return result;
      }
   }
   
   // @throws - IndexOutOfBoundsException if the given index is greater or
   //           equal to size or less than 0   
   private void checkIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index " + index + 
               " is invalid for a list of size " + size);
      }
   }
   
   // @throws - IllegalStateException if the ArrayIntList can't hold
   //           the given capacity number of elements
   private void checkCapacityMayGrow(int capacity) {
      if (elementData.length < capacity) {
         int [] standby = elementData;
         elementData = new int[elementData.length*2];
         for(int i=0; i<standby.length; i++) {
            elementData[i] = standby[i];
         }
         for(int i=standby.length; i<capacity; i++) {
            elementData[i] = 0;
         }
      }
   }
}