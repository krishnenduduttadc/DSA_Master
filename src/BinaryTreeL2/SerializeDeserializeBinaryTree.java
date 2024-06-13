package BinaryTreeL2;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        SerializeDeserializeBinaryTree serDeser = new SerializeDeserializeBinaryTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);


        String serialized = serDeser.serialize(root);
        System.out.println("Serialized: " + serialized);

        Node deserialized = serDeser.deserialize(serialized);
        System.out.println("Deserialized: " + serDeser.serialize(deserialized));
    }

    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public Node deserialize(String data) {
        if (data.equals("null")) return null;
        String[] nodes = data.split(",");
        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            Node parent = queue.poll();
            if (!nodes[i].equals("null")) {
                Node left = new Node(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!nodes[++i].equals("null")) {
                Node right = new Node(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
