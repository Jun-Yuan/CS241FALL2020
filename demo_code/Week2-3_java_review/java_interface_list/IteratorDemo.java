import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorDemo {
    public static void main(String [] args) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        for(int i=0; i < 500000; i++)
            nums.add(i);

        long startTime = System.currentTimeMillis();
        Iterator<Integer> it = nums.iterator();
        int sum = 0;
        while (it.hasNext()) {
            Integer data = it.next();
            sum += data;
        }
        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println("sum=" + sum + "lapsed:"+estimatedTime);
        startTime = System.currentTimeMillis();
        int sum2=0;
        for (int i=0; i< 500000; i++) {
            sum2+= nums.get(i);
        }
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("sum2=" + sum2 + "lapsed:"+estimatedTime);

    }
}
