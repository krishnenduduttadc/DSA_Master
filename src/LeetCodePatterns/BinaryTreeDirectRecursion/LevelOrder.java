package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        LevelOrder lot = new LevelOrder();

        /*
                3
               / \
              9  20
                /  \
               15   7
        */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = lot.levelOrder(root);

        System.out.println("Level Order Traversal: " + result);
        // Expected: [[3], [9, 20], [15, 7]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Queue<Pair> q = new LinkedList<Pair>();

        q.offer(new Pair(root, 1));

        while (q.size() > 0) {
            Pair p = q.peek();
            q.remove();

            TreeNode currentNode = p.node;
            int currentLevel = p.level;
            if (answer.size() < currentLevel) {
                answer.add(new ArrayList<>());
            }

            answer.get(answer.size() - 1).add(currentNode.val);

            if (currentNode.left != null) {
                q.offer(new Pair(currentNode.left, currentLevel + 1));
            }

            if (currentNode.right != null) {
                q.offer(new Pair(currentNode.right, currentLevel + 1));
            }
        }

        return answer;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Helper Pair class
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
