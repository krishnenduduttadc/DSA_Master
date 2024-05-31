package BinaryTreeL1;

public class AddNode {
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

    public static Node add(Node node, int data) {
        // write your code here
        if (node == null) {
            return new Node(data, null, null);
        }

        if (data > node.data) {
            node.right = add(node.right, data);
        } else if (data < node.data) {
            node.left = add(node.left, data);
        } else {
            // Handle duplicate data here
            // For simplicity, we'll just ignore duplicates in this example
            return node; // Ignore duplicate data by returning the node itself
        }

        return node;
    }

    public static void main(String[] args) throws Exception {
        // Hardcode the binary search tree
        Node root = new Node(50,
                new Node(25,
                        new Node(12, null, null),
                        new Node(37,
                                new Node(30, null, null),
                                null
                        )
                ),
                new Node(75,
                        new Node(62, null, null),
                        new Node(87, null, null)
                )
        );

        // Add a new node to the BST
        int data = 61;
        root = add(root, data);

        // Display the updated BST
        display(root);
    }
}
