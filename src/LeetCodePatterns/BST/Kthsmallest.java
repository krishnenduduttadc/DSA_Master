package LeetCodePatterns.BST;

public class Kthsmallest {
    public int count = 0;
    public int ans = -1;

    // Test the kthSmallest function
    public static void main(String[] args) {
        Kthsmallest solver = new Kthsmallest();

        /*
                3
               / \
              1   4
               \
                2
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 3;
        int result = solver.kthSmallest(root, k);
        System.out.println(k + "rd smallest element in BST = " + result);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) return;

        if (node.left != null) {
            inOrder(node.left, k);
        }

        count++;
        if (count == k) {
            ans = node.val;
            return;
        }

        if (node.right != null) {
            inOrder(node.right, k);
        }
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
