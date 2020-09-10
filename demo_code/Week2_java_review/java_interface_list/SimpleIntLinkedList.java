import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SimpleIntLinkedList {
    /**
     * A node within the linked list. Each node contains one data element
     * and a reference to the successor node in the list.
     */
    private static class Node {
        private int data;
        private Node next; // null if the last list element

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this(data, null);
        }
    }

    // first node in the list
    private Node head;

    // number of nodes
    private int size;

    /**
     * Construct an empty linked list.
     */
    public SimpleIntLinkedList() {
        head = null;
        size = 0;
    }

    public boolean add(int element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node finger = head;
            while (finger.next != null) {
                finger = finger.next;
            }
            // finger is now the last node in the list (i.e. finger.next is null)
            finger.next = new Node(element);
        }
        size++;
        return true;
    }

    public int get(int index) {
        Node finger = head;
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        return finger.data;
    }

    public int set(int index, int element) {
        Node finger = head;
        for (int i = 0; i < index; i++) {
            finger = finger.next;
        }
        int oldValue = finger.data;
        finger.data = element;
        return oldValue;
    }

    public void add(int index, int element) {
        if (head == null) {
            // note: assumes that index is also 0
            head = new Node(element);
        } else {
            Node finger = head;
            Node previous = null;
            for (int i = 0; i < index; i++) {
                previous = finger;
                finger = finger.next;
            }
            previous.next = new Node(element, finger);
        }
        size++;
    }

    public int remove(int index) {
        int oldValue;
        if (index == 0) {
            oldValue = head.data;
            head = head.next;
        } else {
            Node finger = head;
            for (int i = 0; i < index - 1; i++) { // stop 1 before index!
                finger = finger.next;
            }
            oldValue = finger.next.data;
            finger.next = finger.next.next;
        }
        size--;
        return oldValue;
    }

    // run a test of a linked list
    public static void main(String[] args) {
        SimpleIntLinkedList list = new SimpleIntLinkedList();
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