/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

import java.util.HashSet;

/**
 *
 * @author krish
 */
public class BST {

    class Node {

        int key, lcount;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
            lcount = 0;
        }
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
            root.lcount++;
        }
        if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    static void Inorder(Node root) {
        if (root == null) {
            return;
        } else {
            Inorder(root.left);
            System.out.print(root.key + " ");
            Inorder(root.right);
        }
    }

    static boolean searchRec(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (x == root.key) {
            return true;
        }
        if (x < root.key) {
            return searchRec(root.left, x);
        }
        if (x > root.key) {
            return searchRec(root.right, x);
        }
        return false;
    }

    static boolean searchI(Node root, int x) {
        Node curr = root;
        while (curr != null) {
            if (x == curr.key) {
                return true;
            }
            if (x < curr.key) {
                curr = curr.left;
            }
            if (x > curr.key) {
                curr = curr.right;
            }

        }
        return false;
    }

    public static Node kthSmallest(Node root, int k) {
        if (root == null) {
            return null;
        }
        int count = root.lcount + 1;
        if (count == k) {
            return root;
        }

        if (count > k) {
            return kthSmallest(root.left, k);
        }

        return kthSmallest(root.right, k - count);
    }

    static Node floor(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (x == root.key) {
                return root;
            } else if (x < root.key) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    static Node ceiling(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (x == root.key) {
                return root;
            } else if (x < root.key) {
                res = root;
                root = root.left;
            } else {

                root = root.right;
            }
        }
        return res;
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (root.key > Integer.MIN_VALUE && root.key < Integer.MAX_VALUE
                && isBST(root.left, Integer.MIN_VALUE, root.key)
                && isBST(root.right, root.key, Integer.MAX_VALUE));
    }
    
    public static boolean isPairSum(Node root, int sum, HashSet<Integer> s) 
    { 
        if(root==null)return false;
        if(isPairSum(root.left,sum,s)==true){
            return true;
        }
        if(s.contains(sum-root.key)){
            return true;
        }else{
            s.add(root.key);
        }
        return isPairSum(root.right,sum,s);
    }

 
    public static void main(String[] args) {
        Node root = null;
        BST tree = new BST();

        int[] data = {50, 30, 20, 40, 70, 60, 80};
        for (int i = 0; i < data.length; i++) {
            root = tree.insertRec(root, data[i]);
        }
        Inorder(root);
        System.out.println("\n80 present? " + searchRec(root, 80));
        System.out.println("\n90 present? " + searchRec(root, 90));

        System.out.println("\n81 present? " + searchI(root, 81));
        System.out.println("\nIs BST? " + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("\nFloor of 58? " + floor(root, 58).key);
        System.out.println("\nCeiling of 58? " + ceiling(root, 58).key);
        System.out.println("\nKth smallest element? " + kthSmallest(root, 4).key);
        System.out.println("\nPair? " + isPairSum(root,70, new HashSet<Integer>()));
        
    }

}
