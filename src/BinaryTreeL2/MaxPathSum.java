package BinaryTreeL2;

public class MaxPathSum {

    static int maxSum = Integer.MIN_VALUE;

    // single recursive function
    static int maxPathSum(Node root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));

        // path passing through current node
        maxSum = Math.max(maxSum, left + right + root.val);

        // return max root-to-node path
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        maxPathSum(root);
        System.out.println(maxSum); // Output: 18
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}
