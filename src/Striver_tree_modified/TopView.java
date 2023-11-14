package Striver_tree_modified;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> topViewNodes = new ArrayList<>();
        if (root == null) {
            return topViewNodes;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int hd = 0; // Horizontal distance

            if (!map.containsKey(hd)) {
                map.put(hd, current.key);
            }

            if (current.left != null) {
                queue.add(current.left);
                map.put(hd - 1, current.left.key);
            }
            if (current.right != null) {
                queue.add(current.right);
                map.put(hd + 1, current.right.key);
            }
        }

        for (int value : map.values()) {
            topViewNodes.add(value);
        }

        return topViewNodes;
    }

    public static void main(String[] args) {
        TopView tree = new TopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);

        ArrayList<Integer> result = topView(root);
        for (Integer nodeValue : result) {
            System.out.print(nodeValue + " ");
        }
    }
}
