package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {
        MaxLevelSum solver = new MaxLevelSum();

        /*
                1
               / \
              7   0
             / \
            7  -8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        System.out.println("Level with maximum sum: " + solver.maxLevelSum(root));
        // Expected: 2 (level 2 sum = 7 + 0 = 7, greater than level 1 sum = 1, and level 3 sum = -1)
    }

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(1, root));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            map.put(top.level, map.getOrDefault(top.level, 0) + top.node.val);

            if (top.node.left != null) {
                q.add(new Pair(top.level + 1, top.node.left));
            }
            if (top.node.right != null) {
                q.add(new Pair(top.level + 1, top.node.right));
            }
        }

        int ans = 1;
        for (Integer level : map.keySet()) {
            if (map.get(level) > map.get(ans)) {
                ans = level;
            }
        }

        return ans;
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
        public int level;
        public TreeNode node;

        public Pair(int level, TreeNode node) {
            this.level = level;
            this.node = node;
        }
    }
}
