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
public class SumofNodes {

    public static int getSum(Node root) {
        if (root == null) {
            return 0;
        }
        return root.data + getSum(root.left) + getSum(root.right);
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        System.out.println("" + getSum(root));
    }
}
