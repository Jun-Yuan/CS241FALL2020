/**
 *  An Iterator that supports traversing a SimpleArrayList.
 *  Normally, this would be integrated into the SimpleArrayList
 *  class by adding the iterator() method to the SimpleArrayList class:
 *
 *  @Override
 *  public Iterator<T> iterator() {
 *    return new SimpleArrayListIterator(this);
 *  }
 *
 *  @author Sean Barker
 *  Updated by Jun Yuan
*/
import java.util.Iterator;
public class SimpleArrayListIterator<T> implements Iterator<T> {

  // the list we're iterating over
  private SimpleArrayList<T> list;

  // current index of the in-progress iteration
  private int nextIndex;

  public SimpleArrayListIterator(SimpleArrayList<T> list) {
    this.list = list;
    nextIndex = 0;
  }

  @Override
  public T next() {
    T val = list.get(nextIndex);
    nextIndex++;
    return val;
  }

  @Override
  public boolean hasNext() {
    return nextIndex < list.size();
  }

}
