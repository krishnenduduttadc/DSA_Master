package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) {
        PathSum2 solver = new PathSum2();

        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \    / \
          7    2  5   1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = solver.pathSum(root, 22);

        System.out.println("Paths with sum 22: " + result);
        // Expected: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> path = new ArrayList<>();
        preOrder(root, 0, path, targetSum);
        return this.answer;
    }

    private void preOrder(TreeNode node, int sumTillParent, List<Integer> pathTillParent, int targetSum) {
        if (node != null) {
            int sumTillMe = sumTillParent + node.val;
            pathTillParent.add(node.val);

            // Check if it's a leaf and path sum matches
            if (node.left == null && node.right == null && sumTillMe == targetSum) {
                answer.add(new ArrayList<>(pathTillParent)); // copy path
            }

            // Continue DFS
            if (node.left != null) {
                preOrder(node.left, sumTillMe, pathTillParent, targetSum);
            }
            if (node.right != null) {
                preOrder(node.right, sumTillMe, pathTillParent, targetSum);
            }

            // Backtrack
            pathTillParent.remove(pathTillParent.size() - 1);
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
