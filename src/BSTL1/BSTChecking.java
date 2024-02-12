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
public class BSTChecking {
    
    static Node root;
    static class Node {
        int data;
        Node left, right;
        Node(int d) {
            data = d;
            left = right = null;
        }
    }
    
    static boolean isBST(Node root,int min,int max){
        if(root==null)return true;
        return (root.data>min && root.data<max && isBST(root.left,min,root.data) && isBST(root.right,root.data,max));
    }
    
    static int prev=Integer.MIN_VALUE;
    
    static boolean isBST(Node root){
        if(root==null)return true;
        if(isBST(root.left)==false)return false;
        if(root.data<=prev)return false;
        prev=root.data;
        return isBST(root.right);      
    }
    public static void main(String[] args) {
        BSTChecking tree = new BSTChecking();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
       System.out.print("\nThe floor is: " + isBST(root,0,500)+ " ");
       System.out.print("\nThe floor is: " + isBST(root)+ " ");
    }
}
