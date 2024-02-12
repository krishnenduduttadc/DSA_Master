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
public class BSTFloorCeil {

    static Node root;

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static Node Floor(Node node, int x) {
        Node res = null;
        while (root != null) {
            if (root.data == x) {
                return root;
            }
            if (root.data > x) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }
        return res;

    }

    static int Ceil(Node node, int x) {
        if (node == null) {
            return -1;
        }
        if (node.data == x) {
            return node.data;
        }
        if (node.data < x) {
            return Ceil(node.right, x);
        }
        int ceil = Ceil(node.left, x);

        return (ceil >= x) ? ceil : node.data;
    }

    public static void main(String[] args) {
        BSTFloorCeil tree = new BSTFloorCeil();
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        Node newhd=Floor(root, 7);
        System.out.print("The floor is: " + newhd.data + " ");
        tree.root = new Node(8);
        tree.root.left = new Node(4);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(14);
        System.out.print("The ceiling is: " + Ceil(root, 7) + " ");
    }
}
