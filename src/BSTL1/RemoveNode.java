package BSTL1;

public class RemoveNode {
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

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static Node remove(Node node, int data) {
        // write your code here
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            if (node.left != null && node.right != null) {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        // Hardcode the binary search tree
        Node root = new Node(50,
                new Node(25,
                        new Node(12, null, null),
                        new Node(37, null, null)
                ),
                new Node(75,
                        new Node(62, null, null),
                        new Node(87, null, null)
                )
        );

        // Data to be removed
        int data = 62;

        // Remove the node
        root = remove(root, data);

        // Display the updated BST
        display(root);
    }
}
