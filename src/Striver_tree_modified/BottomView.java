package Striver_tree_modified;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> bottomViewNodes = new ArrayList<>();
        if (root == null) {
            return bottomViewNodes;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node f = q.poll();
            int hd=0;
            map.put(hd,f.key);
            if (f.left != null) {
                q.add(f.left);
                map.put(hd-1,f.left.key);
            }
            if (f.right != null) {
                q.add(f.right);
                map.put(hd+1,f.right.key);
            }
        }

        for(int x:map.values()){
            bottomViewNodes.add(x);
        }

        return bottomViewNodes;
    }

    public static void main(String[] args) {
        BottomView tree = new BottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<Integer> result = bottomView(root);
        for (Integer nodeValue : result) {
            System.out.print(nodeValue + " ");
        }
    }
}