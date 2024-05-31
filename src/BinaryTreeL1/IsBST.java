package BinaryTreeL1;

public class IsBST {
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

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static class BSTPair {
        boolean isBST;
        int min;
        int max;
    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair b = new BSTPair();
            b.isBST = true;
            b.min = Integer.MAX_VALUE;
            b.max = Integer.MIN_VALUE;
            return b;
        }
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
        return mp;
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.right = new Node(75, null, null);

        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);

        root.right.left = new Node(62, null, null);
        root.right.right = new Node(87, null, null);

        // Check if the tree is a BST
        BSTPair bp = isBST(root);
        System.out.println(bp.isBST);
    }
}
