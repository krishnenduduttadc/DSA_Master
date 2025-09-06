package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        InOrder traversal = new InOrder();

        /*
                1
                 \
                  2
                 /
                3
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = traversal.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
        // Expected: [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return this.answer;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            this.answer.add(node.val);
            inorder(node.right);
        }
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
