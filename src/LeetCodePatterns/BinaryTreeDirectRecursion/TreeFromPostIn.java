package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.HashMap;
import java.util.Map;

public class TreeFromPostIn {
    public static void main(String[] args) {
        TreeFromPostIn builder = new TreeFromPostIn();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = builder.buildTree(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        builder.printInorder(root);   // Expected: 9 3 15 20 7
        System.out.println();

        System.out.print("Postorder of constructed tree: ");
        builder.printPostorder(root); // Expected: 9 15 7 20 3
        System.out.println();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> positionMp = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            positionMp.put(postorder[i], i);
        }
        return constructTree(inorder, positionMp, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] inorder, Map<Integer, Integer> positionMap, int left, int right) {
        if (left > right) {
            return null;
        }

        // Pick the node that appears latest in postorder (root)
        int mostPositionNumber = inorder[left];
        int mostPosition = positionMap.get(inorder[left]);
        int mostPositionInInorder = left;

        for (int i = left + 1; i <= right; i++) {
            int currentPosition = positionMap.get(inorder[i]);
            if (currentPosition > mostPosition) {
                mostPosition = currentPosition;
                mostPositionNumber = inorder[i];
                mostPositionInInorder = i;
            }
        }

        TreeNode node = new TreeNode(mostPositionNumber);
        node.left = constructTree(inorder, positionMap, left, mostPositionInInorder - 1);
        node.right = constructTree(inorder, positionMap, mostPositionInInorder + 1, right);

        return node;
    }

    // Helper: inorder print
    private void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Helper: postorder print
    private void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
