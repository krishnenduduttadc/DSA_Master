/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

/**
 *
 * @author krish
 */
public class CheckBST {

    static int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    static int min(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(min(root.left), min(root.right)));
    }

    public static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        int lmax = max(root.left);
        int rmin = min(root.right);
        if (root.data < lmax) {
            return false;
        }
        if (root.data > rmin) {
            return false;
        }
        boolean isLeftBST = isBST(root.left);
        boolean isRightBST = isBST(root.right);
        if (isLeftBST && isLeftBST) {
            return true;
        }
        return false;

    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("Is BST? " + isBST(root));
    }
}
