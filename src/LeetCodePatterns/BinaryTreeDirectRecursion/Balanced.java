package LeetCodePatterns.BinaryTreeDirectRecursion;

public class Balanced {
    public static void main(String[] args) {
        Balanced checker = new Balanced();

        /*
                3
               / \
              9  20
                /  \
               15   7
        */
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        System.out.println("Tree 1 balanced? " + checker.isBalanced(root1)); // true
    }

    public boolean isBalanced(TreeNode root) {
        int rootHeight = height(root);
        return rootHeight != -1 ? true : false;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
