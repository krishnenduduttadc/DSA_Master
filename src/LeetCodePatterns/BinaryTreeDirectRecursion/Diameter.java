package LeetCodePatterns.BinaryTreeDirectRecursion;

public class Diameter {

    public static void main(String[] args) {
        Diameter tree = new Diameter();

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of Binary Tree: " + tree.diameterOfBinaryTree(root));
        // Expected output: 3 (path is [4 -> 2 -> 5] or [4 -> 2 -> 1 -> 3])
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair p = f(root);
        return p.first;
    }

    private Pair f(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        } else {
            Pair left = f(node.left);
            Pair right = f(node.right);

            int height = Math.max(left.second, right.second) + 1;
            int diameter = Math.max(Math.max(left.first, right.first), left.second + right.second);

            return new Pair(diameter, height);
        }
    }

    // Helper Pair class to store diameter and height
    static class Pair {
        public int first;   // diameter
        public int second;  // height

        public Pair(int x, int y) {
            first = x;
            second = y;
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
