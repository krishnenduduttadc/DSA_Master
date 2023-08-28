package BinaryTreeL2;

import java.util.ArrayList;

public class AllSingleChildParent {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static void exactlyOneChild(Node root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if(root.left==null || root.right==null){
            ans.add(root.val);
        }
        exactlyOneChild(root.left,ans);
        exactlyOneChild(root.right,ans);
    }

    public static ArrayList<Integer> exactlyOneChild(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        exactlyOneChild(root, res);
        return res;
    }

    public static void main(String[] args) {
        AllSingleChildParent tree = new AllSingleChildParent();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(5);

        ArrayList<Integer> ans=exactlyOneChild(root);
        System.out.println(ans);
    }
}
