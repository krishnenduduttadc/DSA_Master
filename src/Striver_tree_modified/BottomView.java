package Striver_tree_modified;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
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
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int hd = 0; // Horizontal distance

            map.put(hd, current.key);

            if (current.left != null) {
                queue.add(current.left);
                map.put(hd - 1, current.left.key);
            }
            if (current.right != null) {
                queue.add(current.right);
                map.put(hd + 1, current.right.key);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bottomViewNodes.add(entry.getValue());
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

