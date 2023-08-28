package BinaryTreeL2;

import java.util.ArrayList;

public class NodeToRootPath {
    static Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static ArrayList<Node> nodeToRootPath_(Node node, int data) {
        // write your code here
        if(node == null) return null;

        if(node.val == data){
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        ArrayList<Node> left = nodeToRootPath_(node.left,data);
        if(left != null){
            left.add(node);
            return left;
        }

        ArrayList<Node> right = nodeToRootPath_(node.right,data);
        if(right != null){
            right.add(node);
            return right;
        }

        return null;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> res = nodeToRootPath_(node,data);
        return res != null ? res : new ArrayList<>();
    }

     public static void main(String[] args) {
        NodeToRootPath tree = new NodeToRootPath();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

         ArrayList<Node> ans = nodeToRootPath(root, 5);
         for (int i = 0; i <ans.size() ; i++) {
             System.out.print(ans.get(i).val+" -> ");
         }

    }
}
