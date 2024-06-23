package BSTL1;


public class BST2GreaterSumTree {
    int greater = 0;

    public TreeNode bstToGst(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        greater = greater + root.val;
        root.val = greater;
        helper(root.left);
    }

    // Utility function to print the tree in inorder fashion
    public void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    // Main method to test the bstToGst function
    public static void main(String[] args) {
        BST2GreaterSumTree solution = new BST2GreaterSumTree();

        // Creating a sample binary search tree:
        //       4
        //      / \
        //     1   6
        //    / \ / \
        //   0  2 5  7
        //        \
        //         3  8

        TreeNode root = solution.new TreeNode(4);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(6);
        root.left.left = solution.new TreeNode(0);
        root.left.right = solution.new TreeNode(2);
        root.left.right.right = solution.new TreeNode(3);
        root.right.left = solution.new TreeNode(5);
        root.right.right = solution.new TreeNode(7);
        root.right.right.right = solution.new TreeNode(8);

        System.out.println("Inorder traversal of the original tree:");
        solution.printInOrder(root);
        System.out.println();

        solution.bstToGst(root);

        System.out.println("Inorder traversal of the Greater Sum Tree:");
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
