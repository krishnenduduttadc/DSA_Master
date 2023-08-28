package BinaryTreeL2;

import java.util.ArrayList;

public class NodesKdistanceAway {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static ArrayList<Integer> distanceK(Node root, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        distanceK(root, target, k, ans);
        return ans;
    }

    public static int distanceK(Node root, int target, int k, ArrayList<Integer> ans) {
        if (root == null) return -1;
        if (root.val == target) {
            kdown(root, k - 0, null, ans);
            return 1;
        }
        int ld = distanceK(root.left, target, k, ans);
        if (ld != -1) {
            kdown(root, k - ld, root.left, ans);
            return ld + 1;
        }

        int rd = distanceK(root.right, target, k, ans);
        if (rd != -1) {
            kdown(root, k - rd, root.right, ans);
            return rd + 1;
        }

        return -1;
    }

    public static void kdown(Node root, int k, Node blockNode, ArrayList<Integer> ans) {
        if (root == null || k < 0 || root == blockNode) {
            return;
        }
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        kdown(root.left, k - 1, blockNode, ans);
        kdown(root.right, k - 1, blockNode, ans);
    }

    public static void main(String[] args) {
        NodesKdistanceAway tree = new NodesKdistanceAway();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<Integer> ans=distanceK(root,7,4);
        System.out.println(ans);
    }
}
