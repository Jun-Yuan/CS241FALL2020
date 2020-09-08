
public class ReferenceTest {
    private static class MyClass{
        private int data;
        public MyClass(int x) {
            data = x;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(MyClass a, MyClass b) {
        MyClass temp = a;
        a = b;
        b = temp;
    }

    public static void swap2(MyClass a, MyClass b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    public static void main(String [] args) {
        //swap two ints
        int x = 3, y = 4;
        swap(x, y) ;
        System.out.println("x="+x+", y="+y);

        MyClass xx = new MyClass(3), yy = new MyClass(4);
        swap(xx, yy) ;
        System.out.println("xx="+xx+", yy="+yy);

        swap2(xx, yy) ;
        System.out.println("xx="+xx+", yy="+yy);
    }
}
