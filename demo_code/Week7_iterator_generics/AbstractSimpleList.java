import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * An abstract class for a class implementing a basic list in which the most
 * important operations of the List interface are supported, but all others are
 * not supported and result in errors if called. Dummy methods for unsupported
 * operations are defined here. Classes that extend SimpleList must implement
 * all of the remaining List methods not defined in this class. Note that
 * subclasses *can* override and implement any of the methods defined here if
 * they want to support them.
 * 
 * @author Sean Barker
 * @param <T>
 *          The type of object stored by the list.
 */
public abstract class AbstractSimpleList<T> implements List<T> {

  @Override
  public boolean contains(Object o) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public int indexOf(Object o) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public int lastIndexOf(Object o) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public ListIterator<T> listIterator() {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException("operation not supported");
  }

  @Override
  public void sort(Comparator<? super T> c) {
    throw new UnsupportedOperationException("operation not supported");
  }

}
