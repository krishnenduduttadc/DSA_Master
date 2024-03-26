package BinaryTreeL1;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    static class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static class QueueObj {

        Node node;
        int hd;

        public QueueObj(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }

        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Integer> topViewMap = new TreeMap<>();
        q.add(new QueueObj(root,0));

        while (!q.isEmpty()) {
            QueueObj f = q.poll();
            if (!topViewMap.containsKey(f.hd)) {
                topViewMap.put(f.hd, f.node.key);
            }
            if (f.node.left != null) {
                q.add(new QueueObj(f.node.left, f.hd - 1));
            }
            if (f.node.right != null) {
                q.add(new QueueObj(f.node.right, f.hd + 1));
            }
        }

        for(int s:topViewMap.values()){
            System.out.println(""+s);
        }
    }

    public static void main(String[] args) {
        /*
                     1
                   /   \
                  2     3
                   \
                    4
                     \
                      5
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);

        System.out.println("Top view of the binary tree is:");
        topView(root);
    }
}
