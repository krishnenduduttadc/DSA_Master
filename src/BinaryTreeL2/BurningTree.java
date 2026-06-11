package BinaryTreeL2;

public class BurningTree {

    static int maxTime = 0;

    static void burn(Node root, Node block, int time) {
        if (root == null || root == block) return;

        maxTime = Math.max(maxTime, time);

        burn(root.left, block, time + 1);
        burn(root.right, block, time + 1);
    }

    static int dfs(Node root, int target) {
        if (root == null) return -1;

        if (root.val == target) {
            burn(root, null, 0);
            return 1;
        }

        int left = dfs(root.left, target);
        if (left != -1) {
            burn(root, root.left, left);
            return left + 1;
        }

        int right = dfs(root.right, target);
        if (right != -1) {
            burn(root, root.right, right);
            return right + 1;
        }

        return -1;
    }

    static int burningTree(Node root, int target) {
        maxTime = 0;
        dfs(root, target);
        return maxTime;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(burningTree(root, 7));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}