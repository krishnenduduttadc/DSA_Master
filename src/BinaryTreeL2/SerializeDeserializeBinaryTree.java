package BinaryTreeL2;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    // Serialize
    static String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        return sb.toString();
    }

    // Deserialize
    static Node deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] arr = data.split(",");
        Node root = new Node(Integer.parseInt(arr[0]));

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (!arr[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if (!arr[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String s = serialize(root);
        System.out.println(s);

        Node newRoot = deserialize(s);
        System.out.println(serialize(newRoot));
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}