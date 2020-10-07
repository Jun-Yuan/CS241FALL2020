import java.util.LinkedList;
import java.util.Deque;
public class QueueDemo {

    //if you want to do enqueue
    private class Queue {
        Deque<Integer> myqueue = new LinkedList<>();
        void enqueue(int x) {
            myqueue.addLast(x);
        }
        int dequeue() {
            return myqueue.removeFirst();
        }

    }

    public static void main(String [] args) {
        Deque<Integer> myqueue = new LinkedList<>();
        //queue:
        myqueue.addLast(1);
        myqueue.removeFirst();

        //stack
        myqueue.addFirst(2);
        myqueue.removeFirst();
    }
}
