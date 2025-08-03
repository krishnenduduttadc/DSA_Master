/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

/**
 * @author krish
 */
public class LCA {

    public static int getLCA(Node root, int a, int b) {
        Node node = getLCA2(root, a, b);
        return node.key;
    }

    static Node getLCA2(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }
        if (node.key > n1 && node.key > n2) {
            return getLCA2(node.left, n1, n2);
        }
        if (node.key < n1 && node.key < n2) {
            return getLCA2(node.right, n1, n2);
        }
        return node;
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("" + getLCA(root, 3, 7));
    }

    public static class Node {
        int key;
        Node left;
        Node right;

        Node(int data) {
            this.key = data;
            this.left = null;
            this.right = null;
        }
    }
}
