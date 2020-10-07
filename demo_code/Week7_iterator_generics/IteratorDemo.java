import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * A demo of using Iterators.
 * updated by Jun Yuan
 */
public class IteratorDemo {

    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<Integer>();
        //Drupit suggsted: what if we use ArrayList?
        //ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=0; i< 500000; i++){
            nums.add(i);
        }

        int sum2=0;
        Iterator<Integer> x = nums.iterator();
        while(x.hasNext()) {
            sum2 += x.next();
        }
        System.out.println("The sum2 =  " + sum2);

        int sum=0;
        for(int i=0; i< nums.size(); i++) {
            sum+= nums.get(i);
        }
        
        System.out.println("The sum =  " + sum);



    
    }
    
}
