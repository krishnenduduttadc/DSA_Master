package BinaryTreeL1;

public class Path2LeaftFromRoot {
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

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }

        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded values for lo and hi
        int lo = 150;
        int hi = 250;

        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);
        root.left.right.left = new Node(30, null, null);
        root.left.right.right = new Node(40, null, null);
        root.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.left.left = new Node(60, null, null);
        root.right.left.right = new Node(70, null, null);
        root.right.right = new Node(87, null, null);

        pathToLeafFromRoot(root, "", 0, lo, hi);
    }
}
