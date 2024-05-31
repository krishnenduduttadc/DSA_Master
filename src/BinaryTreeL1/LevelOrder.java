package BinaryTreeL1;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.remove();
                System.out.print(front.data + " ");
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.right = new Node(75, null, null);

        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);
        root.left.right.left = new Node(30, null, null);

        root.right.left = new Node(62, null, null);
        root.right.left.right = new Node(70, null, null);
        root.right.right = new Node(87, null, null);

        // Level Order Traversal
        levelOrder(root);
    }
}
