package BinaryTreeL3;

public class CheckBST {

    private static boolean checkBST(Node node, long min, long max) {
        if (node == null) return true;
        if (node.key <= min || node.key >= max) return false;

        if (checkBST(node.left, min, node.key) && checkBST(node.right, node.key, max)) {
            return true;
        }
        return false;
    }

    public static boolean isValidBST(Node root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = null;


        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = insertRec(root, data[i]);
        }

        System.out.println(isValidBST(root));
    }

    static Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
            //root.lcount++;
        }
        if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
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
