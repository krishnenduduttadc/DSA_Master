package BinaryTreeL3;

import java.util.HashMap;

public class BinTreePostandIn {

    public static Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, hm);
    }

    private static Node buildTreePostIn(int[] inorder, int is, int ie,
                                        int[] postorder, int ps, int pe,
                                        HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;

        Node root = new Node(postorder[pe]);
        int ri = hm.get(postorder[pe]);

        int leftSize = ri - is;
        root.left = buildTreePostIn(inorder, is, ri - 1,
                postorder, ps, ps + leftSize - 1, hm);
        root.right = buildTreePostIn(inorder, ri + 1, ie,
                postorder, ps + leftSize, pe - 1, hm);
        return root;
    }

    public static void main(String[] args) {
        int postorder[] = {3, 1, 2};
        int inorder[] = {2, 1, 3};
        Node root = buildTree(inorder, postorder);

        // Optional: print tree in preorder to verify
        printPreorder(root);
    }

    public static void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
