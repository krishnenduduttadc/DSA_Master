package Concepts;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static Node root;

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static void levelOrderlinebyline(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            for (int i = 0; i < s; i++) {
                Node f=q.poll();
                System.out.print(f.key+" ");
                if(f.left!=null){
                    q.add(f.left);
                }
                if(f.right!=null){
                    q.add(f.right);
                }

            }
            System.out.println("");
        }
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
        levelOrderlinebyline(root);
    }
}
