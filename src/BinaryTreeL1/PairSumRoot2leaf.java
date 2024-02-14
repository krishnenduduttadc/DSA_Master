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
public class PairSumRoot2leaf {
     public static void rootToLeafPathsSumToK(Node root, int k) {
        rootToLeafPathsSumToK(root, k, "");
    }

    private static void rootToLeafPathsSumToK(Node root, int k, String s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.data == k) {
            System.out.println(s + root.data);
            return;

        }
        s = s + root.data + " ";
        rootToLeafPathsSumToK(root.left, k - root.data, s);
        rootToLeafPathsSumToK(root.right, k - root.data, s);
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
        rootToLeafPathsSumToK(root,13);
    }
}
