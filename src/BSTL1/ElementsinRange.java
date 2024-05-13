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
public class ElementsinRange {

    public static void elementsInRangeK1K2(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if(root.key>=k1 && root.key<=k2){
            System.out.println(root.key);
        }

        if(root.key>k1){
            elementsInRangeK1K2(root.left,k1,k2);
        }

        if(root.key<k2){
            elementsInRangeK1K2(root.right,k1,k2);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        elementsInRangeK1K2(root, 5, 8);
    }
}
