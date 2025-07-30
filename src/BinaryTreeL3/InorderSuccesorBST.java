package BinaryTreeL3;

public class InorderSuccesorBST {

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

    public static Node inorderSuccessor(Node root, Node p) {
        Node successor = null;
        while (root != null) {
            if (p.key >= root.key) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = insertRec(root, data[i]);
        }
        System.out.println(inorderSuccessor(root, root.left).key);
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
