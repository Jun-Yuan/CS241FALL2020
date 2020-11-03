public class BST<DataType extends Comparable<DataType>> {
    TreeNode root;
    public class TreeNode {
        DataType data;
        TreeNode left;
        TreeNode right;

        public TreeNode(DataType item) {
            this.data = item;
        }
    }

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
        } else {
            add(root, item);
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
