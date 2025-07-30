package BinaryTreeL3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBurn {

    private static Node bfsToMapParents(Node root, HashMap<Node, Node> mpp, int start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node res = new Node(-1);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.key == start) res = node;
            if (node.left != null) {
                mpp.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                mpp.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }

    private static int findMaxDistance(HashMap<Node, Node> mpp, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        HashMap<Node, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            int fl = 0;

            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (node.left != null && vis.get(node.left) == null) {
                    fl = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && vis.get(node.right) == null) {
                    fl = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }

                if (mpp.get(node) != null && vis.get(mpp.get(node)) == null) {
                    fl = 1;
                    vis.put(mpp.get(node), 1);
                    q.offer(mpp.get(node));
                }
            }
            if (fl == 1) maxi++;
        }
        return maxi;
    }

    public static int timeToBurnTree(Node root, int start) {
        HashMap<Node, Node> mpp = new HashMap<>();
        Node target = bfsToMapParents(root, mpp, start);
        int maxi = findMaxDistance(mpp, target);
        return maxi;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        int dia = timeToBurnTree(root, 3);
        System.out.println(dia);
    }

    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
