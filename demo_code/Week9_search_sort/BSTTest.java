public class BSTTest {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();

        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(20);
        bst.add(14);
        bst.add(30);
        //bst.add(19);

        System.out.println(bst);

        System.out.println(bst.contains(10));
        System.out.println(bst.contains(30));
        System.out.println(bst.contains(13));
        System.out.println(bst.contains(3));
        System.out.println(bst.contains(50));
        System.out.println(bst.contains(1));
        System.out.println(bst.contains(12));
    }

}
