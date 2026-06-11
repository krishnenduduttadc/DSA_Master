package BinaryTreeL2;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeBasicTreeOperations {

    static int height(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int h = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            h++;

            while (size-- > 0) {
                Node node = q.poll();

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return h;
    }

    static int countNodes(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int count = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            count++;

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return count;
    }

    static int maxValue(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            max = Math.max(max, node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return max;
    }

    static int minValue(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            min = Math.min(min, node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return min;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(height(root));
        System.out.println(countNodes(root));
        System.out.println(maxValue(root));
        System.out.println(minValue(root));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}