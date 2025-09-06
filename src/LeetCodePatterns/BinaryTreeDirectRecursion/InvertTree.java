package LeetCodePatterns.BinaryTreeDirectRecursion;

public class InvertTree {

    public static void main(String[] args) {
        InvertTree tree = new InvertTree();

        // Example tree:
        //       4
        //      / \
        //     2   7
        //    / \ / \
        //   1  3 6  9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.print("Original (in-order): ");
        tree.inorder(root);

        // Invert tree
        tree.invertTree(root);

        System.out.print("\nInverted (in-order): ");
        tree.inorder(root);
    }

    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode node) {
        if (node != null) {
            TreeNode left = invert(node.left);
            TreeNode right = invert(node.right);
            node.left = right;
            node.right = left;
        }
        return node;
    }

    // Helper function to print tree in-order
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}


