/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

/**
 *
 * @author krish
 */
public class NodeswithoutSiblings {

    public static void printNodesWithoutSibling(Node root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            System.out.print(root.data + " ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        printNodesWithoutSibling(root);
    }
}
