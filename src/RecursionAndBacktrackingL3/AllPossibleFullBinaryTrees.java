package RecursionAndBacktrackingL3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {


    static Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public static void main(String[] args) {

        List<TreeNode> trees = build(7);
        System.out.println("Total trees: " + trees.size());
    }

    public static List<TreeNode> build(int n) {

        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode());
        } else if (n % 2 == 1) {

            for (int left = 1; left < n; left += 2) {

                int right = n - 1 - left;

                for (TreeNode l : build(left)) {
                    for (TreeNode r : build(right)) {

                        TreeNode root = new TreeNode();
                        root.left = l;
                        root.right = r;
                        result.add(root);
                    }
                }
            }
        }

        memo.put(n, result);
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
            val = 0;
        }
    }

}
