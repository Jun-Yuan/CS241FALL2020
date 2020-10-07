import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/** Design push/pop for more clear stack-code */
public class StackOfString {
    private List<String> data = new ArrayList<String>();

    public void push(String val) {
        data.add(val);
    }

    public String pop() {
        if(data.size() == 0) {
            //poped out all data already
            throw new IllegalStateException("over popping!");
            // return null;
        }
        return data.remove(data.size()-1);
    }

    public boolean isEmpty() {
        return data.isEmpty();

    }
    //peek at top
    public String peek() {
        return data.get(data.size()-1);
    }

}