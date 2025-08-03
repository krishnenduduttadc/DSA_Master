/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

/**
 * @author krish
 */
public class PrintNodesAtDistK {

    public static void nodesAtDistanceK(Node root, int node, int k) {
        //Your code goes here
        nodesAtDistanceKWithRootDistance(root, node, k);
    }

    public static int nodesAtDistanceKWithRootDistance(Node root, int node, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == node) {
            printNodesDown(root, k);
            return 0;
        }
        int leftHeight = nodesAtDistanceKWithRootDistance(root.left, node, k);
        if (leftHeight != -1) {
            if (leftHeight + 1 == k) {
                System.out.println(root.data);
            } else {
                printNodesDown(root.right, k - leftHeight - 2);

            }
            return leftHeight + 1;
        }

        int rightHeight = nodesAtDistanceKWithRootDistance(root.right, node, k);
        if (rightHeight != -1) {
            if (rightHeight + 1 == k) {
                System.out.println(root.data);
            } else {
                printNodesDown(root.left, k - rightHeight - 2);
            }
            return rightHeight + 1;
        }
        return -1;
    }

    private static void printNodesDown(Node root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        printNodesDown(root.left, k - 1);
        printNodesDown(root.right, k - 1);
    }

    public static void main(String args[]) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.left.left.left = new Node(4);
        root.right = new Node(9);
        root.right.right = new Node(2);
        root.right.right.left = new Node(6);
        nodesAtDistanceK(root, 3, 2);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
