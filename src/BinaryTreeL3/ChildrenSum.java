package BinaryTreeL3;

public class ChildrenSum {

    static void changeTree(Node root) {

        if (root == null)
            return;

        int sum = 0;

        if (root.left != null)
            sum += root.left.key;

        if (root.right != null)
            sum += root.right.key;

        // Push parent value down
        if (sum < root.key) {

            if (root.left != null)
                root.left.key = root.key;

            if (root.right != null)
                root.right.key = root.key;
        }

        changeTree(root.left);
        changeTree(root.right);

        // Pull children values up
        int total = 0;

        if (root.left != null)
            total += root.left.key;

        if (root.right != null)
            total += root.right.key;

        if (root.left != null || root.right != null)
            root.key = total;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(2);
        root.left = new Node(35);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        changeTree(root);

        inorder(root);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}