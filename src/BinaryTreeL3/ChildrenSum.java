package BinaryTreeL3;

public class ChildrenSum {

    // Function to modify the tree to satisfy Children Sum Property
    static void reorder(Node root) {
        if (root == null) return;

        int childSum = 0;

        if (root.left != null) childSum += root.left.key;
        if (root.right != null) childSum += root.right.key;

        // If children sum is less than root, propagate root's value down
        if (childSum < root.key) {
            if (root.left != null) root.left.key = root.key;
            if (root.right != null) root.right.key = root.key;
        }

        // Recurse on children
        reorder(root.left);
        reorder(root.right);

        // After recursion, set root's key to sum of children's keys
        int total = 0;
        if (root.left != null) total += root.left.key;
        if (root.right != null) total += root.right.key;

        if (root.left != null || root.right != null) {
            root.key = total;
        }
    }

    // Wrapper method
    static void changeTree(Node root) {
        reorder(root);
    }

    // Helper method to print inorder traversal of tree
    static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }

    // Driver code
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(35);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right = new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(2);

        changeTree(root);

        System.out.print("Inorder traversal after converting to Children Sum Tree: ");
        printInorder(root);
    }

    // Node class
    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
