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
public class SearchNode {

    public static boolean searchInBST(Node root, int k) {
        if (root == null) {
            return false;
        }
        if (root.data == k) {
            return true;
        }
        if (k < root.data) {
            return searchInBST(root.left, k);
        }
        if (k > root.data) {
            return searchInBST(root.right, k);
        }
        return false;
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        for (int i = 0; i < 10; i++) {
            System.out.println(i+"is Present? "+searchInBST(root, i));
        }
        
    }
}
