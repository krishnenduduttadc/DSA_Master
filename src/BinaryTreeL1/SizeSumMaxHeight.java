package BinaryTreeL1;

public class SizeSumMaxHeight {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lsum = sum(node.left);
            int rsum = sum(node.right);
            return node.data + lsum + rsum;
        }
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        } else {
            int lmax = max(node.left);
            int rmax = max(node.right);
            return Math.max(node.data, Math.max(lmax, rmax));
        }
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        } else {
            int lh = height(node.left);
            int rh = height(node.right);
            return 1 + Math.max(lh, rh);
        }
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);
        root.left.right.left = new Node(30, null, null);
        root.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.left.right = new Node(70, null, null);
        root.right.right = new Node(87, null, null);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }
}
