package LeetCodePatterns.BST;

public class ValidBST {
    // Testing
    public static void main(String[] args) {
        ValidBST validator = new ValidBST();

        /*
                 5
                / \
               3   7
              / \   \
             2   4   8
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(8);

        System.out.println("Is valid BST? " + validator.isValidBST(root)); // true

        // Example of invalid BST
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4); // ❌ violates BST
        System.out.println("Is valid BST? " + validator.isValidBST(root)); // false
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper)) {
            return false;
        }

        return isValid(node.left, lower, node.val) &&
                isValid(node.right, node.val, upper);
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
