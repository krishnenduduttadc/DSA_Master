package BinaryTreeModified;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
     public static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    static Node root;
    public static ArrayList<ArrayList<Integer>> rightview(Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ll=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> l=new ArrayList<>();
            int n=q.size();
            for (int i = 0; i < n; i++) {
                Node f=q.poll();
                if(f.left!=null){
                    q.add(f.left);
                }
                if(f.right!=null){
                    q.add(f.right);
                }
                if(i==n-1){
                    l.add(f.key);
                }
            }
            ll.add(l);
        }
        return ll;
    }

    public static void main(String[] args) {
        RightView tree = new RightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println(rightview(root));

    }
}
