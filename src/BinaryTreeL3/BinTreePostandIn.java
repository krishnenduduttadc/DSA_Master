package BinaryTreeL3;

import java.util.HashMap;
import java.util.Map;

class BinTreePostandIn {

    static Node buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                map);
    }

    static Node build(int[] in, int inStart, int inEnd,
                      int[] post, int postStart, int postEnd,
                      Map<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        Node root = new Node(post[postEnd]);

        int idx = map.get(root.key);
        int leftSize = idx - inStart;

        root.left = build(in, inStart, idx - 1,
                post, postStart, postStart + leftSize - 1,
                map);

        root.right = build(in, idx + 1, inEnd,
                post, postStart + leftSize, postEnd - 1,
                map);

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

        int[] inorder = {2, 1, 3};
        int[] postorder = {3, 1, 2};

        Node root = buildTree(inorder, postorder);

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