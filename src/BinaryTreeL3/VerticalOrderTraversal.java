package BinaryTreeL3;

import java.util.*;

public class VerticalOrderTraversal {

    static List<List<Integer>> verticalTraversal(Node root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {

            Tuple curr = q.poll();
            Node node = curr.node;
            int col = curr.col;
            int row = curr.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).offer(node.key);

            if (node.left != null)
                q.offer(new Tuple(node.left, col - 1, row + 1));

            if (node.right != null)
                q.offer(new Tuple(node.right, col + 1, row + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> temp = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {

                while (!pq.isEmpty())
                    temp.add(pq.poll());
            }

            ans.add(temp);
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        System.out.println(verticalTraversal(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static class Tuple {
        Node node;
        int col, row;

        Tuple(Node node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}