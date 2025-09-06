package LeetCodePatterns.BinaryTreeDirectRecursion;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {

    // Test the Codec
    public static void main(String[] args) {
        SerializeDeserialize codec = new SerializeDeserialize();

        /*
                1
               / \
              2   3
                 / \
                4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        String check = codec.serialize(deserialized);
        System.out.println("Check serialize after deserialize: " + check);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null ");
            } else {
                sb.append(node.val).append(" ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = queue.poll();

            if (!nodes[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = leftChild;
                queue.offer(leftChild);
            }

            i++; // move to right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = rightChild;
                queue.offer(rightChild);
            }
        }

        return root;
    }

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
