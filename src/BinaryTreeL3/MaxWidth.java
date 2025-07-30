package BinaryTreeL3;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {

    public static int widthOfBinaryTree(Node root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;    //to make the id starting from zero
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().num - mmin;
                Node node = q.peek().node;
                q.poll();
                if (i == 0) first = cur_id;
                if (i == size - 1) last = cur_id;
                if (node.left != null)
                    q.offer(new Pair2(node.left, cur_id * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair2(node.right, cur_id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.left = new Node(7);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.right = new Node(6);

        int maxWidth = widthOfBinaryTree(root);
        System.out.println("The maximum width of the Binary Tree is " + maxWidth);


    }

    static class Pair2 {
        Node node;
        int num;

        Pair2(Node _node, int _num) {
            num = _num;
            node = _node;
        }
    }
}


