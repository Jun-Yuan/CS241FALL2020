
public class ReferenceTest {
    private static class MyClass {
        private int data;
        public MyClass(int d) {
            data = d;
        }
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static void swap_correct(MyClass a, MyClass b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    public static void swap(MyClass a, MyClass b) {
        MyClass temp = a;
        a = b;
        b = temp;
    }
    //inner/nested class
    public static void swap (int a, int b) {
        //swap
        // save a into a temp holder
        // store b into a, we can overwrite a here becz a's backed in temp
        // store temp into b
        int temp = a;
        a = b;
        b = temp;
    }

    public static void main(String [] args) {
        //swap two ints
        int x = 3, y = 4;
        swap(x, y) ; //x=4 y=3
        System.out.println("x="+x+", y="+y);

        MyClass obj1 = new MyClass(3);
        MyClass obj2 = new MyClass(4);
        swap(obj1, obj2);
        System.out.println("obj1="+obj1+", obj2="+obj2);
        swap_correct(obj1, obj2);
        System.out.println("obj1="+obj1+", obj2="+obj2);
    }
}
