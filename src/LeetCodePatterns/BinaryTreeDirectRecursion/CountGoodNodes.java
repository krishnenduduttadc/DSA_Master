package LeetCodePatterns.BinaryTreeDirectRecursion;

public class CountGoodNodes {
    private int count = 0;

    public static void main(String[] args) {
        CountGoodNodes solver = new CountGoodNodes();

        /*
                3
               / \
              1   4
             /   / \
            3   1   5
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        int result = solver.goodNodes(root);

        System.out.println("Number of good nodes: " + result);
        // Expected: 4
    }

    public int goodNodes(TreeNode root) {
        f(root, null);
        return count;
    }

    private void f(TreeNode node, Integer maxTillParent) {
        if (node != null) {
            int maxTillMe = node.val;

            if (maxTillParent == null) { // root node
                count++;
            } else {
                if (node.val >= maxTillParent) {
                    count++;
                }
                maxTillMe = Math.max(maxTillMe, maxTillParent);
            }

            f(node.left, maxTillMe);
            f(node.right, maxTillMe);
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
