package BinaryTreeL3;

import java.util.HashMap;
import java.util.Map;

class BinTreePreandIn {

    static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
    }

    static Node build(int[] pre, int ps, int pe,
                      int[] in, int is, int ie,
                      Map<Integer, Integer> map) {
        if (ps > pe || is > ie)
            return null;
        Node root = new Node(pre[ps]);
        int idx = map.get(root.key);
        int leftSize = idx - is;
        root.left = build(pre, ps + 1, ps + leftSize,
                in, is, idx - 1, map);
        root.right = build(pre, ps + leftSize + 1, pe,
                in, idx + 1, ie, map);
        return root;
    }

    static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {10, 20, 40, 50, 30, 60};
        int[] inorder = {40, 20, 50, 10, 60, 30};

        Node root = buildTree(preorder, inorder);

        preorder(root);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}