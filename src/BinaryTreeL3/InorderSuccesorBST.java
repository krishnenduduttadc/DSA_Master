package BinaryTreeL3;

public class InorderSuccesorBST {
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
        SearchBST tree = new SearchBST();

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }
        System.out.println(inorderSuccessor(root, root.left).key);
    }
}
