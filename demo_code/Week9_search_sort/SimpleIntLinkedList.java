import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SimpleIntLinkedList {
    //node should be inner class
    //for reasons:
    //1) only simpleIntLinkedList will use it
    //2) Outer class can directly access next or data
    private static class Node {
        private int data;
        private Node next;
        public Node(int d, Node node) {
            this.data = d;
            this.next = node;
        }
        public Node(int d) {
            this(d, null);
        }
    }

    private Node head;
    private int size;

    public SimpleIntLinkedList() {
        //this must be empty
        head = null;
        size = 0;
    }

    public int size() {
        //#1 no counter. walk through the list and count the elements
        //#2 busy update. whenever you add/delete, we incre/decre a counter
        //pros and cons?
        return size;
    }
    //Precondition: index must be [0, size]
    //
    public void add(int index, int newdata) throws
            IndexOutOfBoundsException {
        if(index <0 || index>size) {
            throw new IndexOutOfBoundsException();
        }
        // 1. create a node that holds new data
        Node newnode = new Node (newdata);
        //2. find the spot to insert
        if(index == 0 ) {
            //insert at the head
             newnode.next = head;
             head = newnode;
        } else {
            Node finger = head;
            Node previous = null;
            for(int i=0; i<index;i++) {
                previous = finger;
                finger = finger.next;
            }
            //3.inserting b/w previous and finger nodes
            previous.next = newnode;
            newnode.next = finger;
        }
        size ++;
    }
    public void add(int newdata) {
        if (head == null) {
            head = new Node(newdata);
        }  else {
            Node newNode = new Node(newdata);
            Node finger = head; //start with 1st node
            //if finger points to last node in list?
            //if so, inject new data here
            //or, move on to the next
            while (finger.next !=null) {
                finger = finger.next;
            }
            finger.next = newNode;
        }
        size++;
    }
    //say: remove 3rd element in the list
    //index starts with zero
    // removing 3
    public void remove(int index) {
        if (index == 0) {
            //never never never lose track of head!
            head = head.next;
        } else {
            Node finger = head;
            for(int i=0; i<index-1; i++) {
                finger = finger.next;
            }
            finger.next = finger.next.next;
        }
        size --;
    }

    //precondition: 0<index<size;
    //postcondition: return the value of index-th node (index starting with 0) in the list.
    public int get(int index) {
        if(index <0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node finger = head;
            for(int i=0; i<index-1; i++) {
                finger = finger.next;
            }
            return finger.data;
        }

    }

    public boolean contains(int value) {
        Node finger = head;
        while(finger != null && finger.data != value) {
            finger = finger.next;
        }
        if(finger.data == value)
            return true;
        else return false;
    }

    public boolean contains2(Node head, int value) {
        //i can break down the list into two parts:
        //the current node by head, and the n-1 list
        //i check both parts
        boolean sub = false;
        if(head.data == value) {
            return true;
        }
        else if(head.next != null){
            sub = contains2(head.next, value);
        }
        return sub;

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