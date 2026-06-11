package BinaryTreeL2;

public class Camera {

    static int cameras = 0;

    static int dfs(Node root) {
        if (root == null) return 1;   // covered
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1) {
            cameras++;
            return 0;                // has camera
        }
        if (left == 0 || right == 0)
            return 1;                // covered
        return -1;                   // needs camera
    }

    static int minCameraCover(Node root) {
        cameras = 0;
        if (dfs(root) == -1)
            cameras++;
        return cameras;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(minCameraCover(root));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}