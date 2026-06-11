package BinaryTreeL3;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {

    static String serialize(Node root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr == null) {
                sb.append("n ");
                continue;
            }

            sb.append(curr.key).append(" ");

            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    static Node deserialize(String data) {

        if (data.isEmpty())
            return null;

        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {

            Node parent = q.poll();

            if (!values[i].equals("n")) {
                parent.left = new Node(Integer.parseInt(values[i]));
                q.offer(parent.left);
            }
            i++;

            if (!values[i].equals("n")) {
                parent.right = new Node(Integer.parseInt(values[i]));
                q.offer(parent.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        String s = serialize(root);
        System.out.println(s);

        Node newRoot = deserialize(s);
        System.out.println(newRoot.key);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}