package BSTL1;

public class CheckBST {
    static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.key, Math.max(max(root.left), max(root.right)));
    }

    static int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;
        return Math.min(root.key, Math.min(min(root.left), min(root.right)));
    }

    public static boolean isBST(Node root) {
        if (root == null) return true;

        int lmax = max(root.left);
        int rmin = min(root.right);

        if (root.key <= lmax) return false;
        if (root.key >= rmin) return false;

        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        return isLeftBST && isRightBST;
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("Is BST? " + isBST(root));  // Output: true
    }

    public static class Node {
        int key;
        Node left, right;

        Node(int data) {
            this.key = data;
        }

        Node(int data, Node left, Node right) {
            this.key = data;
            this.left = left;
            this.right = right;
        }
    }
}
