package BinaryTreeL2;


import java.util.ArrayList;
import java.util.List;

public class NodesKdistanceAway {

    static void kDown(Node root, int k, Node block, List<Integer> ans) {
        if (root == null || root == block || k < 0)
            return;
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        kDown(root.left, k - 1, block, ans);
        kDown(root.right, k - 1, block, ans);
    }

    static int dfs(Node root, int target, int k, List<Integer> ans) {

        if (root == null)
            return -1;

        if (root.val == target) {
            kDown(root, k, null, ans);
            return 1;
        }

        int left = dfs(root.left, target, k, ans);
        if (left != -1) {
            kDown(root, k - left, root.left, ans);
            return left + 1;
        }

        int right = dfs(root.right, target, k, ans);
        if (right != -1) {
            kDown(root, k - right, root.right, ans);
            return right + 1;
        }

        return -1;
    }

    static List<Integer> distanceK(Node root, int target, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, target, k, ans);
        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(distanceK(root, 7, 4));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}