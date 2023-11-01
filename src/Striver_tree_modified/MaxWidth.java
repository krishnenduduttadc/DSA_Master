package Striver_tree_modified;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public static int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int ml=0;
        while (!q.isEmpty()) {
            int n = q.size();
            int l = 0;
            for (int i = 0; i < n; i++) {
                Node f = q.remove();
                if (f.left != null) {
                    q.add(f.left);
                }
                if (f.right != null) {
                    q.add(f.right);
                }
                l++;
            }
            if(l>ml){
                ml=l;
            }

        }
        return ml;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(8);

        int depth = widthOfBinaryTree(root);

        System.out.print(depth + " ");


    }
}
