package BinaryTreeL1;

public class LeftClonedToNormal {
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

    public static Node transBackFromLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }
        Node lnn = transBackFromLeftClonedTree(node.left.left);
        Node rnn = transBackFromLeftClonedTree(node.right);

        node.left = lnn;
        node.right = rnn;
        return node;
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded tree construction for the left cloned tree
        Node root = new Node(50, null, null);
        root.left = new Node(50, null, null);
        root.left.left = new Node(25, null, null);
        root.left.left.left = new Node(25, null, null);
        root.left.left.left.left = new Node(12, null, null);
        root.left.left.left.left.left = new Node(12, null, null);
        root.left.left.left.left.left.left = null;
        root.left.left.left.left.left.right = null;
        root.left.left.left.left.right = null;
        root.left.left.left.right = null;
        root.left.left.right = new Node(37, null, null);
        root.left.left.right.left = new Node(37, null, null);
        root.left.left.right.left.left = new Node(30, null, null);
        root.left.left.right.left.left.left = new Node(30, null, null);
        root.left.left.right.left.left.left.left = null;
        root.left.left.right.left.left.left.right = null;
        root.left.left.right.left.left.right = null;
        root.left.left.right.right = null;
        root.left.right = null;
        root.right = new Node(75, null, null);
        root.right.left = new Node(75, null, null);
        root.right.left.left = new Node(62, null, null);
        root.right.left.left.left = new Node(62, null, null);
        root.right.left.left.left.left = null;
        root.right.left.left.left.right = null;
        root.right.left.left.right = null;
        root.right.left.right = new Node(70, null, null);
        root.right.left.right.left = new Node(70, null, null);
        root.right.left.right.left.left = null;
        root.right.left.right.left.right = null;
        root.right.left.right.right = null;
        root.right.right = new Node(87, null, null);
        root.right.right.left = new Node(87, null, null);
        root.right.right.left.left = null;
        root.right.right.left.right = null;
        root.right.right.right = null;

        root = transBackFromLeftClonedTree(root);
        display(root);
    }
}
