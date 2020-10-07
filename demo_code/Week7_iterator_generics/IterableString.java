import java.util.Iterator;

/**
 * A class containing a string that supports iteration
 * over the characters of the string.
 *
 * @author Sean Barker
 * updated by Jun Yuan
*/
public class IterableString implements Iterable<Character> {
    
    // the actual iterator supporting iteration over the string
    private static class StringIterator implements Iterator<Character> {

        private int curIndex;

        private String s;
        
        public StringIterator(String s) {
            this.s = s;
            curIndex = 0;
        }
        
        @Override
        public boolean hasNext() {
            return curIndex < s.length();
        }
        
        @Override
        public Character next() {
            char val = s.charAt(curIndex);
            curIndex++;
            return val;
        }
    }
 
    private String str;
    
    public IterableString(String str) {
       this.str = str; 
    }
    
    @Override
    public String toString() {
        return str;
    }
    
    // construct an iterator that will iterate over this string
    @Override
    public Iterator<Character> iterator() {
        return new StringIterator(str);
    }
    
}
