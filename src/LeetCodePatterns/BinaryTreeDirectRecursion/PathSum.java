package LeetCodePatterns.BinaryTreeDirectRecursion;

public class PathSum {
    private boolean answer = false;

    public static void main(String[] args) {
        PathSum checker = new PathSum();

        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \      \
          7    2      1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("Has path sum 22: " + checker.hasPathSum(root, 22)); // true
        System.out.println("Has path sum 26: " + checker.hasPathSum(root, 26)); // true (5->8->13)
        System.out.println("Has path sum 18: " + checker.hasPathSum(root, 18)); // true (5->8->4->1)
        System.out.println("Has path sum 27: " + checker.hasPathSum(root, 27)); // false
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        preOrder(root, 0, targetSum);
        return answer;
    }

    private void preOrder(TreeNode node, int sumTillParent, int targetSum) {
        if (node != null) {
            int sumTillMe = sumTillParent + node.val;

            // Continue exploring children
            if (node.left != null) {
                preOrder(node.left, sumTillMe, targetSum);
            }
            if (node.right != null) {
                preOrder(node.right, sumTillMe, targetSum);
            }

            // Check if leaf node satisfies target sum
            if (sumTillMe == targetSum && node.left == null && node.right == null) {
                answer = true;
            }
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
