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
public class BSTDelete {

    static Node root;

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node insert(Node root, int x) {
        Node temp = new Node(x);
        Node curr = root, parent = null;
        while (curr != null) {
            parent = curr;
            if (curr.key > x) {
                curr = curr.left;
            } else if (curr.key < x) {
                curr = curr.right;
            } else {
                return root;
            }
        }
        if (parent == null) {
            return temp;
        }
        if (parent.key > x) {
            parent.left = temp;
        } else {
            parent.right = temp;
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

    static Node delete(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.key > x) {
            root.left = delete(root.left, x);
        } else if (root.key < x) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node succ = getSucc(root);
                root.key = succ.key;
                root.right = delete(root.right, succ.key);
            }

        }
        return root;
    }

    static void delete(int x) {
        delete(root, x);
    }

    static Node getSucc(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        Inorder(root);
        delete(20);
        System.out.print("\nAfter deletion=====\n ");
        Inorder(root);

    }
}
