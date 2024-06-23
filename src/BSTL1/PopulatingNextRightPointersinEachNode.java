package BSTL1;

import RecursionAndBacktrackingL1.Solution;

public class PopulatingNextRightPointersinEachNode {
    static class Node {
        int val;
        Node left, right, next;

        Node(int val) {
            this.val = val;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Node ans = root;

        while (root.left != null) {
            Node temp = root;
            while (temp != null) {
                temp.left.next = temp.right;
                if (temp.next != null) {
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            root = root.left;
        }
        return ans;
    }

    // Utility method to print the connected structure
    public void printConnectedTree(Node root) {
        while (root != null) {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.val);
                if (temp.next != null) {
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
            System.out.println();
            root = root.left;
        }
    }

    // Main method to test the connect function
    public static void main(String[] args) {
        PopulatingNextRightPointersinEachNode solution = new PopulatingNextRightPointersinEachNode();

        // Create a sample perfect binary tree:
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Connect the tree
        Node connectedRoot = solution.connect(root);

        // Print the connected structure to verify
        System.out.println("Connected Tree:");
        solution.printConnectedTree(connectedRoot);
    }
}
