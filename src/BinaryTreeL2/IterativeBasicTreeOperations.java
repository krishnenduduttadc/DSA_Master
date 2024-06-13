package BinaryTreeL2;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeBasicTreeOperations {
    public static class Node {
        int val;
        Node left, right;

        Node(int x) {
            val = x;
        }
    }

    public int getHeight(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return height;
    }

    public int getNodeCount(Node root) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return count;
    }

    public int getMax(Node root) {
        if (root == null) throw new IllegalArgumentException("Tree is empty");

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxValue = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxValue = Math.max(maxValue, node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return maxValue;
    }

    public int getMin(Node root) {
        if (root == null) throw new IllegalArgumentException("Tree is empty");

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int minValue = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            minValue = Math.min(minValue, node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        return minValue;
    }

    public static void main(String[] args) {
        IterativeBasicTreeOperations solution = new IterativeBasicTreeOperations();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Height of the tree: " + solution.getHeight(root));
        System.out.println("Number of nodes in the tree: " + solution.getNodeCount(root));
        System.out.println("Maximum value in the tree: " + solution.getMax(root));
        System.out.println("Maximum value in the tree: " + solution.getMin(root));



    }
}
