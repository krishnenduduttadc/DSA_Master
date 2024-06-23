package BSTL1;

import RecursionAndBacktrackingL1.Solution;

public class RecoverBST {
    TreeNode f, s, prev;

    public void recoverTree(TreeNode root) {
        f = s = prev = null;
        inorder(root);
        int t = f.val;
        f.val = s.val;
        s.val = t;
    }

    private void inorder(TreeNode curr) {
        if (curr == null) return;

        inorder(curr.left);
        if (prev != null && curr.val < prev.val) {
            if (f == null) {
                f = prev;
            }
            s = curr;
        }
        prev = curr;
        inorder(curr.right);
    }

    // Utility function to print the tree in inorder fashion
    public void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    // Main method to test the recoverTree function
    public static void main(String[] args) {
        RecoverBST solution = new RecoverBST();

        // Creating a sample binary search tree with two nodes swapped:
        // Original BST:  1
        //               / \
        //              3   4
        //               \
        //                2
        //
        // Swapped BST:   1
        //               / \
        //              4   3
        //               \
        //                2

        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(4);
        root.right = solution.new TreeNode(3);
        root.left.right = solution.new TreeNode(2);

        System.out.println("Inorder traversal of the original tree:");
        solution.printInOrder(root);
        System.out.println();

        solution.recoverTree(root);

        System.out.println("Inorder traversal of the recovered tree:");
        solution.printInOrder(root);
        System.out.println();
    }

    // TreeNode class definition
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
