import java.util.List;

/**
 * A simple list implementation backed by an array. Supports a subset of the
 * operations in the full List interface (the most important ones). Dynamically
 * resizes (recreates) the array to avoid running out of room.
 * 
 * @author Sean Barker
 * @param <T>
 *          The type of data held in the list.
 */
public class SimpleArrayList<T> extends AbstractSimpleList<T>
    implements List<T> {

  /**
   * Default starting array capacity if not specified.
   */
  private static final int DEFAULT_START_CAPACITY = 10;

  /**
   * The internal array storing the list elements.
   */
  private Object[] elementData;

  /**
   * The number of list elements currently stored in the array (typically less
   * than the array length).
   */
  private int elementCount;

  /**
   * Construct a new list with the given starting capacity.
   * 
   * @param startingCapacity
   *          The desired starting list capacity.
   */
  public SimpleArrayList(int startingCapacity) {
    // we really want elementData to be type T[], but Java can't create an array
    // of a generic type, so we have to use Object[]
    elementData = new Object[startingCapacity];
    elementCount = 0;
  }

  /**
   * Construct a new list with the default starting capacity.
   */
  public SimpleArrayList() {
    this(DEFAULT_START_CAPACITY); // just call the other constructor
  }

  /**
   * Ensure that the internal array has at least minCapacity size. Creates a new
   * array and copies over the existing elements if the current capacity is less
   * than minCapacity.
   * 
   * @param minCapacity
   *          The minimum desired list capacity.
   */
  private void ensureCapacity(int minCapacity) {
    if (elementData.length < minCapacity) {

      int newLength = elementData.length;
      if (newLength == 0) {
        newLength = 1;
      }
      while (newLength < minCapacity) {
        newLength *= 2; // double the list size
      }

      // copy elements from existing array to new array
      Object[] newElementData = new Object[newLength];
      for (int i = 0; i < elementCount; i++) {
        newElementData[i] = elementData[i];
      }
      elementData = newElementData; // save the new array

    }
  }

  @Override
  public int size() {
    return elementCount;
  }

  @Override
  public boolean isEmpty() {
    return elementCount == 0;
  }

  @Override
  public boolean add(T element) {
    ensureCapacity(elementCount + 1);
    elementData[elementCount] = element;
    elementCount++;
    return true;
  }

  @Override
  public void add(int index, T element) {
    ensureCapacity(elementCount + 1);

    // shift all existing elements right starting at index
    for (int i = elementCount; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }

    elementData[index] = element;
    elementCount++;
  }

  @Override
  public T get(int index) {
    return (T) elementData[index];
  }

  @Override
  public T set(int index, T element) {
    T previousElement = (T) elementData[index];
    elementData[index] = element;
    return previousElement;
  }

  @Override
  public T remove(int index) {
    T removedElement = get(index);
    elementCount--;

    // shift all existing elements left starting at index
    for (int i = index; i < elementCount; i++) {
      elementData[i] = elementData[i + 1];
    }

    // clear the now-unused space in the array
    elementData[elementCount] = null;

    return removedElement;
  }

  @Override
  public boolean contains(Object obj) {
    for (int i = 0; i < elementCount; i++) {
      if (elementData[i].equals(obj)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    String str = "[";
    for (int i = 0; i < elementCount; i++) {
      str += elementData[i];
      if (i < elementCount - 1) {
        str += ", ";
      }
    }
    return str + "]";
  }

}
