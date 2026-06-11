package BinaryTreeL2;

public class CountCompleteTreeNodes {

    static int leftHeight(Node root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.left;
        }
        return h;
    }

    static int rightHeight(Node root) {
        int h = 0;
        while (root != null) {
            h++;
            root = root.right;
        }
        return h;
    }

    static int countNodes(Node root) {
        if (root == null) return 0;

        int lh = leftHeight(root);
        int rh = rightHeight(root);

        if (lh == rh)
            return (1 << lh) - 1;    // perfect tree

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(countNodes(root));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}