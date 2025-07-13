package BSTL1;


public class InorderSuccessor {
    // Main method to test the inorderSuccessor function
    public static void main(String[] args) {
        InorderSuccessor solution = new InorderSuccessor();

        // Create a sample BST:
        //        20
        //       /  \
        //     10    30
        //    /  \     \
        //   5   15    40
        //      /  \
        //     12  18

        Node root = null;
        root = solution.insert(root, 20);
        root = solution.insert(root, 10);
        root = solution.insert(root, 30);
        root = solution.insert(root, 5);
        root = solution.insert(root, 15);
        root = solution.insert(root, 12);
        root = solution.insert(root, 18);
        root = solution.insert(root, 40);

        // Test cases for inorder successors
        Node testNode = root.left;  // Node with data 10
        Node successor = solution.inorderSuccessor(root, testNode);
        System.out.println("Inorder successor of " + testNode.data + " is: " + (successor != null ? successor.data : "null"));

        testNode = root.left.right;  // Node with data 15
        successor = solution.inorderSuccessor(root, testNode);
        System.out.println("Inorder successor of " + testNode.data + " is: " + (successor != null ? successor.data : "null"));

        testNode = root.right;  // Node with data 30
        successor = solution.inorderSuccessor(root, testNode);
        System.out.println("Inorder successor of " + testNode.data + " is: " + (successor != null ? successor.data : "null"));

        testNode = root.right.right;  // Node with data 40
        successor = solution.inorderSuccessor(root, testNode);
        System.out.println("Inorder successor of " + testNode.data + " is: " + (successor != null ? successor.data : "null"));
    }

    // Function to find the inorder successor of the Node x in BST (rooted at 'root')
    public Node inorderSuccessor(Node root, Node x) {
        Node successor = null;

        // Traverse the BST to find the node x
        while (root != null) {
            if (root.data > x.data) {
                successor = root;
                root = root.left;
            } else if (root.data < x.data) {
                root = root.right;
            } else {
                break;
            }
        }

        // If x has a right subtree, find the leftmost node in that subtree
        if (root != null && root.right != null) {
            Node rootp1 = root.right;
            while (rootp1.left != null) {
                rootp1 = rootp1.left;
            }
            return rootp1;
        }

        // Otherwise, return the last node where we took a left turn to reach x
        return successor;
    }

    // Utility function to insert a node into BST
    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}
