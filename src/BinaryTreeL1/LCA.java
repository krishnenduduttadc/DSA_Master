/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;


/**
 * @author krish
 */
public class LCA {


    public static Node getLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }

        // If current node matches either a or b
        if (root.data == a || root.data == b) {
            return root;
        }

        Node left = getLCA(root.left, a, b);
        Node right = getLCA(root.right, a, b);

        // If a and b are found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return the non-null child
        return (left != null) ? left : right;
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("" + getLCA(root, 3, 7).data);
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
