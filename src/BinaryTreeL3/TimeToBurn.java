package BinaryTreeL3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBurn {

    // Build parent map and find target node
    static Node buildParentMap(Node root, int start,
                               HashMap<Node, Node> parent) {

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        Node target = null;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.key == start)
                target = curr;

            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return target;
    }

    static int timeToBurnTree(Node root, int start) {

        HashMap<Node, Node> parent = new HashMap<>();
        Node target = buildParentMap(root, start, parent);
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                if (parent.containsKey(curr) &&
                        !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);

        System.out.println(timeToBurnTree(root, 3));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}