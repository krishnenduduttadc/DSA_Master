package BinaryTreeL3;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BoundaryTraversal {

    static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    static void leftBoundary(Node root, List<Integer> res) {
        root = root.left;

        while (root != null) {
            if (!isLeaf(root))
                res.add(root.key);

            root = (root.left != null) ? root.left : root.right;
        }
    }

    static void leaves(Node root, List<Integer> res) {
        if (root == null)
            return;

        if (isLeaf(root)) {
            res.add(root.key);
            return;
        }

        leaves(root.left, res);
        leaves(root.right, res);
    }

    static void rightBoundary(Node root, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        root = root.right;

        while (root != null) {
            if (!isLeaf(root))
                stack.push(root.key);

            root = (root.right != null) ? root.right : root.left;
        }

        while (!stack.isEmpty())
            res.add(stack.pop());
    }

    static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        if (!isLeaf(root))
            res.add(root.key);

        leftBoundary(root, res);
        leaves(root, res);
        rightBoundary(root, res);

        return res;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        System.out.println(boundaryTraversal(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}