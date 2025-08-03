/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTL1;

import java.util.ArrayList;

/**
 * @author krish
 */
public class FindPath {

    public static ArrayList<Integer> getPath(Node root, int data) {

        if (root == null) {
            return null;
        }
        if (root.key == data) {
            ArrayList<Integer> op = new ArrayList<>();
            op.add(root.key);
            return op;
        }

        ArrayList<Integer> rl = getPath(root.left, data);
        if (rl != null) {
            rl.add(root.key);
            return rl;
        }
        ArrayList<Integer> rr = getPath(root.right, data);
        if (rr != null) {
            rr.add(root.key);
            return rr;
        } else {
            return null;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        ArrayList<Integer> a = getPath(root, 7);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + "-");
        }
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
