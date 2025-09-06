package LeetCodePatterns.BinaryTreeDirectRecursion;

public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric checker = new IsSymmetric();

        // Symmetric tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode f1, TreeNode f2) {
        if (f1 == null && f2 == null) return true;
        if (f1 == null || f2 == null) return false;
        return f1.val == f2.val && isSym(f1.left, f2.right) && isSym(f1.right, f2.left);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
