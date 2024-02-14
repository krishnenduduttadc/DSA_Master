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
 * @author krishnendu
 */
public class LevelWise {

    public static void LevelWise(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            Node front = q.remove();
            System.out.print(front.data + " ");
            if (front.left != null) {
                q.add(front.left);
            }
            if (front.right != null) {
                q.add(front.right);
            }
        }
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

    public static void printLeftView(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.remove();
                if (i == 0) {
                    System.out.print(front.data + " ");
                }

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

    public static void printRightView(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.remove();
                if (i == size - 1) {
                    System.out.print(front.data + " ");
                }

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

    public static void preOrder(Node root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);

        LevelWise(root);
        System.out.println("");
        printLevelWise(root);
        System.out.println("");
        printLeftView(root);
        System.out.println("");
        printRightView(root);
    }
}
