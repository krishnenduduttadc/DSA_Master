package Striver_tree;

public class LCABST {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        int curr = root.key;
        if(curr < p.key && curr < q.key) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.key && curr > q.key) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        SearchBST tree = new SearchBST();

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }

        System.out.println(lowestCommonAncestor(root,root.left.left,root.right).key);
    }
}
