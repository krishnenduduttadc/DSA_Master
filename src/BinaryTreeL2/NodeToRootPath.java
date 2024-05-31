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

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        ArrayList<Node> path = new ArrayList<>();
        if (node == null) return path;
        if (node.val == data) {
            path.add(node);
            return path;
        }

        ArrayList<Node> leftPath = nodeToRootPath(node.left, data);
        if(leftPath!=null){
            leftPath.add(node);
            return leftPath;
        }

        ArrayList<Node> rightPath = nodeToRootPath(node.right, data);
        if(rightPath!=null){
            rightPath.add(node);
            return rightPath;
        }

        return path;
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

        ArrayList<Node> ans = nodeToRootPath(root, 6);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i).val + " -> ");
        }
        System.out.println("stop");
    }
}