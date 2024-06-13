package BinaryTreeL2;

public class BinaryTreeMaximumPathSum {
    public static class Node {
        int val;
        Node left, right;

        Node(int x) {
            val = x;
        }
    }

    private int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(Node node) {
        if (node == null) return 0;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int localMax = node.val + left + right;
        maxSum = Math.max(maxSum, localMax);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println("Maximum Path Sum: " + solution.maxPathSum(root));  // Output: 6
    }
}
