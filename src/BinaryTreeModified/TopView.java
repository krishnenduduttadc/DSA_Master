package BinaryTreeModified;

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
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node f = q.poll();
            int hd = 0;
            if (!map.containsKey(hd)) {
                map.put(hd, f.key);
            }
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
            topViewNodes.add(x);
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