package Striver_tree;

public class CheckBST {

    private static boolean checkBST(Node node, long min, long max) {
        if(node == null) return true;
        if(node.key <= min || node.key >= max) return false;

        if(checkBST(node.left, min, node.key) && checkBST(node.right, node.key, max)) {
            return true;
        }
        return false;
    }
    public static boolean isValidBST(Node root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        Node root = null;
        SearchBST tree = new SearchBST();

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }

        System.out.println(isValidBST(root));
    }
}
