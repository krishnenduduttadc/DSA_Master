/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;

import java.util.ArrayList;

/**
 * @author krish
 */
public class LongestLeaf2Root {
    public static ArrayList<Integer> longestRootToLeafPath(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> left = longestRootToLeafPath(root.left);
        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        // Pick longer path
        if (left.size() > right.size()) {
            result.addAll(left);
        } else {
            result.addAll(right);
        }

        result.add(root.data);
        return result;
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
        ArrayList<Integer> a = longestRootToLeafPath(root);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + "-");
        }
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
