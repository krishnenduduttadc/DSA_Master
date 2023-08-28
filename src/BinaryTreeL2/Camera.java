package BinaryTreeL2;

public class Camera {
    static Node root;
    public static int cameras = 0;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static int MinCamerasInBT_(Node root) {
        if (root == null) return 1;

        int lchild = MinCamerasInBT_(root.left);
        int rchild = MinCamerasInBT_(root.right);

        if (lchild == -1 || rchild == -1) {
            cameras++;
            return 0;
        }

        if (lchild == 0 || rchild == 0) return 1;

        return -1;
    }

    public static int MinCamerasInBT(Node root) {
        if (MinCamerasInBT_(root) == -1) cameras++;
        return cameras;
    }

    public static void main(String[] args) {
        Camera tree = new Camera();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int ans = MinCamerasInBT(root);
        System.out.println(ans);
    }
}
