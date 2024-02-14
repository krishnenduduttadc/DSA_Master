/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

/**
 *
 * @author krishnendu
 */
public class FindNode {

    public static boolean isNodePresent(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }

        return isNodePresent(root.left, x) || isNodePresent(root.right, x);

    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        System.out.println("Node present? " + isNodePresent(root, 400));
    }
}
