package BinaryTreeL3;

import java.util.ArrayList;
import java.util.List;

public class IterativePostorder {

    static void postorder(Node root, List<Integer> ans) {

        if (root == null)
            return;

        postorder(root.left, ans);
        postorder(root.right, ans);

        ans.add(root.key);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        List<Integer> ans = new ArrayList<>();

        postorder(root, ans);

        System.out.println(ans);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}