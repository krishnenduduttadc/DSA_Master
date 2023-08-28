package BinaryTreeL2;

public class BurningTree {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    private static int maxTime = 0;

    public static void burnTree(Node root, Node blockNode, int time) {
        if (root == null || root == blockNode) return;

        maxTime = Math.max(maxTime, time);

        burnTree(root.left, blockNode, time + 1);
        burnTree(root.right, blockNode, time + 1);
    }

    public static int burningTree_(Node root, int fireNode) {
        if (root == null) return -1;

        if (root.val == fireNode) {
            burnTree(root, null, 0);
            return 1;
        }

        int leftTime = burningTree_(root.left, fireNode);
        if (leftTime != -1) {
            burnTree(root, root.left, leftTime);
            return leftTime + 1;
        }

        int rightTime = burningTree_(root.right, fireNode);
        if (rightTime != -1) {
            burnTree(root, root.right, rightTime);
            return rightTime + 1;
        }

        return -1;
    }

    public static int burningTree(Node root, int fireNode) {
        burningTree_(root, fireNode);
        return maxTime;
    }

    public static void main(String[] args) {
        BurningTree tree = new BurningTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int ans = burningTree(root, 7);
        System.out.println(ans);
    }
}
