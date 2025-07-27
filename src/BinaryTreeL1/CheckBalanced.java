/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

/**
 * @author krish
 */
public class CheckBalanced {

    static int isBalanced(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = isBalanced(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = isBalanced(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        } else {
            return Math.abs(lh - rh) + 1;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        System.out.println("Balanced? " + isBalanced(root));
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
