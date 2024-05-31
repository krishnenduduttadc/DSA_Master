package BinaryTreeL1;

public class Tilt {
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

    static int tilt = 0;
    public static int tilt(Node node){
        if (node == null) {
            return 0;
        }
        int ls = tilt(node.left);
        int rs = tilt(node.right);
        int ltilt = Math.abs(ls - rs);
        tilt += ltilt;
        int sum = ls + rs + node.data;
        return sum;
    }

    public static void main(String[] args) {
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

        tilt(root);
        System.out.println(tilt);
    }
}
