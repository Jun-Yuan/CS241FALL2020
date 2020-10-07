import java.util.Iterator;
import java.util.List;

/**
 * A simple singly-linked list implementation.
 *
 * @author Sean Barker
 * Updated By Jun Yuan: Added Iterator.
 */
public class SimpleLinkedList<T> extends AbstractSimpleList<T> implements List<T> {

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

    public class SimpleLinkedListIterator<T> implements Iterator<T> {

        // next Node in the traversal
        private Node<T> nextNode;

        public SimpleLinkedListIterator(Node<T> headNode) {
            nextNode = headNode;
        }

        @Override
        public T next() {
            T val = nextNode.data;
            nextNode = nextNode.next; // advance the traversal
            return val;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

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
