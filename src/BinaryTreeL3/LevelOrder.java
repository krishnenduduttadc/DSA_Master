package BinaryTreeL3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    static Node root;

    public static List<Integer> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        List<Integer> wrapList = new LinkedList<Integer>();

        if (root == null) return wrapList;

        queue.offer(root);
        while (!queue.isEmpty()) {

            if (queue.peek().left != null)
                queue.offer(queue.peek().left);

            if (queue.peek().right != null)
                queue.offer(queue.peek().right);

            wrapList.add(queue.poll().key);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        LevelOrder tree = new LevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        List<Integer> wrapList = levelOrder(root);
        for (int it : wrapList) {
            System.out.print(it + " ");
        }

    }

    public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}
