package BinaryTreeL2;

public class PathSum {
    static Node root;

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return (targetSum - root.val) == 0;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        boolean ans = hasPathSum(root, 11);

        System.out.print(ans);


    }

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }


}
