package BinaryTreeL3;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    static int widthOfBinaryTree(Node root) {

        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int minIndex = q.peek().index;

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                int index = curr.index - minIndex;

                if (i == 0)
                    first = index;

                if (i == size - 1)
                    last = index;

                if (curr.node.left != null)
                    q.offer(new Pair(curr.node.left, 2 * index + 1));

                if (curr.node.right != null)
                    q.offer(new Pair(curr.node.right, 2 * index + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.left = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(6);

        System.out.println(widthOfBinaryTree(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static class Pair {
        Node node;
        int index;

        Pair(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}