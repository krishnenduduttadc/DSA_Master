/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author krish
 */
public class RemoveLeafNodes {

    public static Node removeAllLeaves(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeAllLeaves(root.left);
        root.right = removeAllLeaves(root.right);
        return root;
    }

    public static void printLevelWise(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.remove();
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        printLevelWise(root);
        System.out.println("");
        Node nrt = removeAllLeaves(root);
        printLevelWise(nrt);
    }
}
