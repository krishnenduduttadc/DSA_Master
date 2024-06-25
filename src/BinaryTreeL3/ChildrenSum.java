package BinaryTreeL3;

public class ChildrenSum {
    static void reorder(Node  root) {
        if (root == null) return;
        int child = 0;
        if (root.left!=null) {
            child += root.left.key;
        }
        if (root.right!=null) {
            child += root.right.key;
        }

        if (child < root.key) {
            if (root.left!=null) root.left.key = root.key;
            else if (root.right!=null) root.right.key = root.key;
        }

        reorder(root.left);
        reorder(root.right);

        int tot = 0;
        if (root.left!=null) tot += root.left.key;
        if (root.right!=null) tot += root.right.key;
        if (root.left!=null || root.right!=null) root.key = tot;
    }
    static void changeTree(Node  root) {
        reorder(root);
    }

    public static void main(String args[]) {

        Node  root = new Node(2);
        root.left = new Node(35);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        changeTree(root);

    }
}
