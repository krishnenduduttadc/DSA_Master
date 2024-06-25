package BinaryTreeL3;

import java.util.LinkedList;

public class MaxDepth {
    //static Node root;
    private static int levelOrder(Node root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-- > 0) {
                Node remNode = queue.removeFirst();
                if (remNode.left != null) {
                    queue.addLast(remNode.left);
                }
                if (remNode.right != null) {
                    queue.addLast(remNode.right);
                }
            }

            level++;
        }

        return level;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int depth = levelOrder(root);

        System.out.print(depth + " ");


    }
}
