import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A priority queue implemented using a heap, which is stored in an ArrayList.
 * This implementation only operates on Comparable objects, though an alternate implementation
 * could instead take a Comparator as a constructor parameter.
 * This class uses a "min-heap" approach in which the minimum value is considered
 * the highest priority (i.e., the root node).  The opposite but equivalent approach
 * is a "max-heap" in which the root is the maximum value.
 */
public class SimplePriorityQueue<T extends Comparable<T>> extends AbstractSimpleQueue<T> implements Queue<T> {

    private List<T> data;

    public SimplePriorityQueue() {
        data = new ArrayList<T>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // get the index of a parent node
    private static int parent(int i) {
        return (i - 1) / 2;
    }

    // get the index of a left child
    private static int left(int i) {
        return 2 * i + 1;
    }

    // get the index of a right child
    private static int right(int i) {
        return 2 * i + 2;
    }

    public boolean add(T e) {
       //step 1: for the shape:
        data.add(e);
        //step 2: fix the order by heapifying up
        //start heapifying from the newly added element
        //all the way up to the root.
        //idex of newly add element?
        //well it is at the end...
        heapifyUp(data.size()-1);//idx of the newly added leaf
        return true;
    }

    private void heapifyUp(int idx_leaf) {
        //walk up the tree
        int idx_parent = parent(idx_leaf);
        T child_value = data.get(idx_leaf);
        T parent_value = data.get(idx_parent);

        while(idx_leaf >0 /*finger == null*/ && child_value.compareTo(parent_value) < 0) {
            data.set(idx_leaf, parent_value);
            // parent value sets into leaf
            //pulled down parent value
            idx_leaf = idx_parent; // parent's idx becomes the new idx_leaf, just like
            //finger=finger.next; also check finger==null?
            idx_parent = parent(idx_leaf);
        }
        data.set(idx_leaf, child_value);
    }

    // Inserts the specified element into this queue if it is possible to do so immediately
    // without violating capacity restrictions. Returns true if added or false otherwise.
    public boolean offer(T e) {
        return add(e);
    }

    // Retrieves and removes the head of this queue,
    // or returns null if this queue is empty.
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T minVal = data.get(0); // highest priority value (i.e., minimum value)
        data.set(0, data.get(data.size() - 1)); // move last node to root (index 0)
        if (data.size() > 1) {
            pushDown(0); // push down root
        }
        return minVal;
    }

    private void pushDown(int root) {
        int heapSize = data.size();
        T value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if (right(root) < heapSize && data.get(childpos + 1).compareTo(data.get(childpos)) < 0) {
                    childpos++;
                }
                // childpos now indexes smaller of two children
                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos; // keep moving down
                } else { // found right location
                    data.set(root,value);
                    return;
                }
            } else { // at a leaf! insert and halt
                data.set(root,value);
                return;
            }
        }
    }

    // Retrieves, but does not remove, the head of this queue,
    // or returns null if this queue is empty.
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    // Retrieves and removes the head of this queue. This method differs
    // from poll only in that it throws a NoSuchElementException if this queue is empty.
    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return poll();
    }

    // Retrieves, but does not remove, the head of this queue. This method differs
    // from peek only in that it throws a NoSuchElementException if this queue is empty.
    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }
}