package LeetCodePatterns.BinaryTreeDirectRecursion;

public class SumofLeftLeaves {
    private int sum = 0;

    public static void main(String[] args) {
        SumofLeftLeaves solver = new SumofLeftLeaves();

        /*
                3
               / \
              9   20
                 /  \
                15   7
           Left leaves: 9 + 15 = 24
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solver.sumOfLeftLeaves(root);

        System.out.println("Sum of left leaves: " + result);
        // Expected: 24
    }

    public int sumOfLeftLeaves(TreeNode root) {
        preOrder(root, false);
        return this.sum;
    }

    private void preOrder(TreeNode node, boolean leftChild) {
        if (node != null) {
            // leaf check + must be a left child
            if (node.left == null && node.right == null && leftChild) {
                this.sum += node.val;
            }
            if (node.left != null) {
                preOrder(node.left, true);
            }
            if (node.right != null) {
                preOrder(node.right, false);
            }
        }
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
