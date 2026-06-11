package BinaryTreeL3;

public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    static int maxPathSum(Node root) {
        dfs(root);
        return maxSum;
    }

    static int dfs(Node root) {
        if (root == null)
            return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxSum = Math.max(maxSum, left + right + root.key);
        return root.key + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}