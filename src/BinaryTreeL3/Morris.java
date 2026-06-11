package BinaryTreeL3;

import java.util.ArrayList;
import java.util.List;

public class Morris {

    static List<Integer> preorderTraversal(Node root) {

        List<Integer> preorder = new ArrayList<>();
        Node curr = root;

        while (curr != null) {

            if (curr.left == null) {
                preorder.add(curr.key);
                curr = curr.right;
            } else {

                Node prev = curr.left;

                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                if (prev.right == null) {

                    preorder.add(curr.key); // visit node
                    prev.right = curr;      // create thread
                    curr = curr.left;
                } else {

                    prev.right = null;      // remove thread
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);

        System.out.println(preorderTraversal(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}