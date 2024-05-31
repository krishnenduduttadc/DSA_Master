package BinaryTreeL1;

public class PrintSingleChildNodes {
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

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null) {
            return;
        }
        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.data);
        } else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
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

        printSingleChildNodes(root, null);
    }
}
