package LeetCodePatterns.BinaryTreeDirectRecursion;

public class SameTree {
    public static void main(String[] args) {
        SameTree checker = new SameTree();

        // Example tree 1
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Example tree 2
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Example tree 3 (different)
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(3);
        r.right = new TreeNode(2);

        // Run comparisons
        System.out.println("p vs q: " + checker.isSameTree(p, q)); // true
        System.out.println("p vs r: " + checker.isSameTree(p, r)); // false
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        } else {
            return false;
        }
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
