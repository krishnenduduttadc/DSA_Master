package BinaryTreeL1;

public class IsBalanced {
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

    static boolean isBal = true;

    public static int isBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = isBalanced(node.left);
        int rh = isBalanced(node.right);
        int gap = Math.abs(lh - rh);
        if (gap > 1) {
            isBal = false;
        }
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static void main(String[] args) {
        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.right = new Node(75, null, null);

        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);

        root.left.right.left = new Node(30, null, null);
        root.left.right.right = new Node(51, null, null);

        root.right.left = new Node(62, null, null);
        root.right.left.left = new Node(60, null, null);
        root.right.left.right = new Node(70, null, null);

        // Checking if the tree is balanced
        isBalanced(root);
        System.out.println(isBal);
    }
}
