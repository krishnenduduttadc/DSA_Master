package BinaryTreeL2;


public class MaxPathSum {

    static int maxSum;

    static int dfs(Node root) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return root.val + Math.max(left, right);
    }

    static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root)); // 18
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}