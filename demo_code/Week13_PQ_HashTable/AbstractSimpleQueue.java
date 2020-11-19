import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * An abstract class for a class implementing a basic queue in which the most
 * important operations of the Queue interface are supported, but all others are
 * not supported and result in errors if called. Dummy methods for unsupported
 * operations are defined here. Classes that extend AbstractSimpleQueue must
 * implement all of the remaining Queue methods not defined in this class. Note
 * that subclasses *can* override and implement any of the methods defined here
 * if they want to support them.
 *
 * @author Sean Barker
 * @param <T>
 *          The type of object stored by the queue.
 */
public abstract class AbstractSimpleQueue<T> implements Queue<T> {

    @Override
    public boolean contains(Object o) {
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
    public <K> K[] toArray(K[] a) {
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
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation not supported");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("operation not supported");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("operation not supported");
    }

}