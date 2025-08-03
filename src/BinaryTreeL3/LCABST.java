package BinaryTreeL3;

public class LCABST {

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

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;
        int curr = root.key;
        if (curr < p.key && curr < q.key) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.key && curr > q.key) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = insertRec(root, data[i]);
        }

        System.out.println(lowestCommonAncestor(root, root.left.left, root.right).key);
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
