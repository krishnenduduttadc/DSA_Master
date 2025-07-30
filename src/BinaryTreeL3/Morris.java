package BinaryTreeL3;

import java.util.ArrayList;

public class Morris {

    static ArrayList<Integer> preorderTraversal(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Node cur = root;
        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.key);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.key);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        ArrayList<Integer> preorder = new ArrayList<>();
        preorder = preorderTraversal(root);

        System.out.println("The Preorder Traversal is: ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i) + " ");
        }

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
