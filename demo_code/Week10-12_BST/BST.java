import jdk.nashorn.api.tree.Tree;

import java.util.NoSuchElementException;

public class BST<DataType extends Comparable<DataType>> {
    private TreeNode root;
    private class TreeNode {
        DataType data;
        TreeNode left;
        TreeNode right;

        public TreeNode(DataType item) {
            this.data = item;
        }
    }
    //constructor
    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public void add(DataType item) {
        if (isEmpty()) {
            System.out.println("Adding the root: " + item);
            root = new TreeNode(item);
            //head for the first node.
        } else {
            add(root, item);
        }
    }
    // we will have BST<Person> bst = new BST<Person>;
    //Datatype is going to be person, and key is going to be id
    // bst.add(person1); //10001
    //bst.add(person2); //6
    //bst.add(person3);
    //...
    //search(id == 6), want to know salary of person whose id==6
    // search(DataType)?
    //Person result_person = new Person(6, null, null, -1);; result_person as a place holder
    // search(Person result_person);
    // 1.client knows their DataType.
    //2. client also knows their comparesTo
    // 3. client knows the key type of their DataType
    //it is client's job to call generic search
    //with a place_holder of datatype with key prefilled
    // Person place_holder_for_key = new Person(6, null, null, -1);
    // Person value = bst.search(place_holder_for_key);
    // value -> [6,"joe", "smith", 10000] <- a tree node.dat
    // Person value = new Person(bst.search(place_holder_for_key)); deep-copy
    // value -> [6,"joe", "smith", 10000]
    //          [6,"joe", "smith", 10000] <- a tree node.dat
    //bst.delete(6);

    public DataType search(DataType item) {
        if(isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return search_helper(root, item);
        }

    }
    private DataType search_helper(TreeNode node, DataType item) {
        if(node.data.compareTo(item) == 0) {
            return node.data;
        } else if(node.data.compareTo(item) <0 ){
            if (node.right== null){
                throw new NoSuchElementException();
            } else {
                return search_helper(node.right, item);
            }
        } else {
            if (node.left== null){
                throw new NoSuchElementException();
            } else {
                return search_helper(node.left, item);
            }
        }
    }


    private void add(TreeNode node, DataType item) {
        // Compare node.data with item
        System.out.println("I am at " + node.data);
        int res = node.data.compareTo(item);
        if (res < 0) {
            if (node.right == null) {
                System.out.println("Adding " + item + " to the right");
                node.right = new TreeNode(item);
            } else {
                add(node.right, item);
            }
        } else if (res > 0) {
            if (node.left == null) {
                System.out.println("Adding " + item + " to the left");
                node.left = new TreeNode(item);
            } else {
                add(node.left, item);
            }
        } else {
            System.out.println("Don't do that.");
        }
    }

    public boolean contains(DataType item) {
        if (isEmpty()) {
            return false;
        }

        TreeNode tmp = root;
        while(tmp != null) {
            int res = tmp.data.compareTo(item);
            if (res < 0) {
                tmp = tmp.right;
            }
            else if (res > 0) {
                tmp = tmp.left;
            }
            else {
                return true;
            }
        }

        return false;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, root, 0);
        return sb.toString();

    }

    private void toString(StringBuilder sb, TreeNode root, int depth) {
        if (root == null) {
            for (int i = 0; i < depth; i++) {
                sb.append("\t");
            }
            sb.append("-\n");
            return;
        }

        toString(sb, root.right, depth + 1);

        // Put self in string, use sb.append()
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(root.data);
        sb.append("\n");

        toString(sb, root.left, depth + 1);
    }
}
