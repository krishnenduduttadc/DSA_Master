/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

/**
 * @author krish
 */
public class CheckCousins {

    public static boolean isCousin(Node root, int p, int q) {
        // Write your code here
        int depth1 = depth(root, p);
        int depth2 = depth(root, q);

        if (depth1 == 0 || depth2 == 0) {
            return false;
        }

        if (depth1 == depth2) {
            return !siblings(root, p, q);
        } else {
            return false;
        }

    }

    private static boolean siblings(Node root, int p, int q) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.right != null) {
            if (root.right.data == p && root.left.data == q) {
                return true;
            } else if (root.right.data == q && root.left.data == p) {
                return true;
            } else {
                return siblings(root.left, p, q) || siblings(root.right, p, q);
            }
        }

        if (root.left != null) {
            return siblings(root.left, p, q);
        } else {
            return siblings(root.right, p, q);
        }

    }

    private static int depth(Node root, int p) {
        if (root == null) {
            return 0;
        }

        if (root.data == p) {
            return 1;
        }

        int left = depth(root.left, p);
        if (left != 0) {
            return left + 1;
        }
        int right = depth(root.right, p);

        if (right != 0) {
            return right + 1;
        } else {
            return 0;
        }

    }

    public static void main(String args[]) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.left.left.left = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(2);
        root.right.right.left = new Node(6);
        System.out.println("" + isCousin(root, 8, 2));
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
