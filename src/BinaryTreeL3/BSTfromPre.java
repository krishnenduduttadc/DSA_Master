package BinaryTreeL3;

class BSTfromPre {

    static int idx = 0;

    static Node bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    static Node build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound)
            return null;
        Node root = new Node(preorder[idx++]);
        root.left = build(preorder, root.key);
        root.right = build(preorder, bound);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 2, 4};
        Node root = bstFromPreorder(preorder);
        System.out.println(root.key);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}