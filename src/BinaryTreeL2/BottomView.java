package BinaryTreeL2;

import java.util.ArrayList;
import java.util.LinkedList;

public class BottomView {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }
    public static class vPair{
        Node node = null;
        int h1 = 0;
        vPair(Node node, int h1){
            this.node = node;
            this.h1 = h1;
        }
    }

    public static void width(Node node, int h1, int[] minMax){
        if(node == null) return;

        minMax[0] = Math.min(minMax[0], h1);
        minMax[1] = Math.max(minMax[1], h1);

        width(node.left, h1 - 1, minMax);
        width(node.right, h1 + 1, minMax);
    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        int[] minMax = new int[2];
        width(root,0, minMax);

        int len =  minMax[1] - minMax[0] + 1;
        for(int i = 0; i < len; i++) ans.add(0);

        LinkedList<vPair> que = new LinkedList<>();
        que.add(new vPair(root, Math.abs(minMax[0])));

        while(que.size() !=0){
            int size = que.size();
            while(size-- > 0){
                vPair rp = que.removeFirst();

                Node node = rp.node;
                int h1 = rp.h1;

                ans.set(h1,node.val);

                if(node.left != null) que.addLast(new vPair(node.left, h1 - 1));
                if(node.right != null) que.addLast(new vPair(node.right, h1 + 1));
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        BottomView tree = new BottomView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<Integer> ans=bottomView(root);
        System.out.println(ans);
    }
}
