import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple singly-linked list implementation.
 *
 * @author Sean Barker
 */
public class SimpleLinkedList<T>  implements List<T> {

    /**
     * A node within the linked list. Each node contains one data element
     * and a reference to the successor node in the list.
     */
    private static class Node<T> {
        private T data;
        private Node<T> next; // null if the last list element

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }
    }

    // first node in the list
    private Node<T> head;

    // number of nodes
    private int size;

    /**
     * Construct an empty linked list.
     */
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T element) {
        if (head == null) {
            head = new Node<T>(element);
        } else {
            Node<T> finger = head;
            while (finger.next != null) {
                finger = finger.next;
            }
            // finger is now the last node in the list (i.e. finger.next is null)
            finger.next = new Node<T>(element);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        Node<T> finger = head;
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        return finger.data;
    }

    @Override
    public T set(int index, T element) {
        Node<T> finger = head;
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        T oldValue = finger.data;
        finger.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, T element) {
        if (head == null) {
            // note: assumes that index is also 0
            head = new Node<T>(element);
        } else {
            Node<T> finger = head;
            Node<T> previous = null;
            for (int i = 0; i < index; i++) {
                previous = finger;
                finger = finger.next;
            }
            previous.next = new Node<T>(element, finger);
        }
        size++;
    }

    @Override
    public T remove(int index) {
        T oldValue;
        if (index == 0) {
            oldValue = head.data;
            head = head.next;
        } else {
            Node<T> finger = head;
            for (int i = 0; i < index - 1; i++) { // stop 1 before index!
                finger = finger.next;
            }
            oldValue = finger.next.data;
            finger.next = finger.next.next;
        }
        size--;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    // run a test of a linked list
    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(2, 123);
        list.remove(1);
        list.add(3, 55);
        System.out.println(list.get(3));
        System.out.println(list.get(2));
        System.out.println(list.get(1));
    }

}