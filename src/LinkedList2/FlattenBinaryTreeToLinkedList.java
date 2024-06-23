package LinkedList2;

import RecursionAndBacktrackingL1.Solution;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattn(root);
    }

    private TreeNode flattn(TreeNode root) {
        if (root == null) return null;

        TreeNode lt = flattn(root.left);
        TreeNode rt = flattn(root.right);

        if (lt != null) {
            lt.right = root.right;  // Connect the end of the left subtree to the start of the right subtree
            root.right = root.left; // Move the left subtree to the right
            root.left = null;       // Nullify the left pointer
        }

        // Return the last node in the flattened tree
        if (rt != null) {
            return rt;
        } else if (lt != null) {
            return lt;
        } else {
            return root;
        }
    }

    // Utility function to print the flattened tree
    public void printFlattenedTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    // Main method to test the flatten function
    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList solution = new FlattenBinaryTreeToLinkedList();

        // Creating a sample binary tree:
        //     1
        //    / \
        //   2   5
        //  / \   \
        // 3   4   6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        System.out.println("Original Tree:");
        solution.printFlattenedTree(root); // This will just print the root node, as the tree is not flattened yet

        solution.flatten(root);

        System.out.println("Flattened Tree:");
        solution.printFlattenedTree(root);
    }
}

// TreeNode class definition for completeness
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
