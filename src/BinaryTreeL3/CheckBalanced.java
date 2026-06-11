package BinaryTreeL3;

public class CheckBalanced {

    static boolean isBalanced(Node root) {
        return height(root) != -1;
    }

    static int height(Node root) {

        if (root == null)
            return 0;

        int left = height(root.left);

        if (left == -1)
            return -1;

        int right = height(root.right);

        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(6);

        System.out.println(isBalanced(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}