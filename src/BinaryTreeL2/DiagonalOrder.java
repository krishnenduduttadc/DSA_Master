package BinaryTreeL2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalOrder {

    static ArrayList<ArrayList<Integer>> diagonalOrder(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (size-- > 0) {
                Node curr = q.poll();
                while (curr != null) {
                    diagonal.add(curr.val);
                    if (curr.left != null)
                        q.offer(curr.left);
                    curr = curr.right;
                }
            }
            ans.add(diagonal);
        }
        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diagonalOrder(root));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}