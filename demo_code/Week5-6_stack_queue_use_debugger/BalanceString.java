import java.util.ArrayList;
        import java.util.List;
/** Design push/pop for more clear stack-code */
public class BalanceString {

    public static boolean is_balanced(String st) {
        StackOfString stack = new StackOfString();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(Character.toString(ch));
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                String leftbrace = stack.pop();
                if (leftbrace.equals("(") && ch == ')') {
                    //match case
                } else if (leftbrace.equals("[") && ch == ']') {
                    //match case
                } else if (leftbrace.equals("{") && ch == '}') {
                    //match case
                } else {
                    //no matc
                    return false;
                    //case 1
                }
            } else {
                return false;
            }
        }
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String [] args) {

        System.out.println(is_balanced("{()}]"));
    }
}