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
public class BSTSearch {

    Node root;

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    BSTSearch() {
        root = null;
    }

    void insert(int k) {
        root = insertRec(root, k);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }
        return root;
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void inorderRec() {
        inorderRec(root);
    }

    boolean search(Node root, int key) {
        if (root == null) {
            return false;
        } else if (key == root.key) {
            return true;
        } else if (root.key < key) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }

    }

    void search(int key) {
        System.out.println("\nIs present " + search(root, key));
    }

    boolean searchI(Node root, int key) {
        while (root != null) {
            if (root.key == key) {
                return true;
            } else if (root.key < key) {
                root = root.right;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    void searchI(int key) {
        System.out.println("\nIs present " + searchI(root, key));
    }

    public static void main(String[] args) {
        BSTSearch tree = new BSTSearch();

        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inorderRec();
        tree.search(70);
        tree.searchI(70);
    }
}
