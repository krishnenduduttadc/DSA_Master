package BinaryTreeL2;

//import RecursionAndBacktrackingL1.Solution;

import java.util.HashMap;

public class BinaryTreeFromPreAndInorder {
    HashMap<Integer, Integer> map;

    // Main method to test the buildTree function
    public static void main(String[] args) {
        BinaryTreeFromPreAndInorder solution = new BinaryTreeFromPreAndInorder();

        // Sample preorder and inorder arrays
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of the constructed tree:");
        solution.printInOrder(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(pre[ps]);

        int count = idx - is;
        root.left = construct(pre, ps + 1, ps + count, in, is, idx - 1);
        root.right = construct(pre, ps + count + 1, pe, in, idx + 1, ie);

        return root;
    }

    // Utility function to print the tree in inorder fashion
    public void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    // TreeNode class definition
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
