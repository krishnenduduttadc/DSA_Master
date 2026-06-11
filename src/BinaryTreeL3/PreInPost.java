package BinaryTreeL3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPost {

    static void allTraversal(Node root,
                             List<Integer> pre,
                             List<Integer> in,
                             List<Integer> post) {

        if (root == null)
            return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair curr = st.pop();

            if (curr.state == 1) {

                pre.add(curr.node.key);
                curr.state++;
                st.push(curr);

                if (curr.node.left != null)
                    st.push(new Pair(curr.node.left, 1));
            } else if (curr.state == 2) {

                in.add(curr.node.key);
                curr.state++;
                st.push(curr);

                if (curr.node.right != null)
                    st.push(new Pair(curr.node.right, 1));
            } else {

                post.add(curr.node.key);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        allTraversal(root, pre, in, post);

        System.out.println("Preorder : " + pre);
        System.out.println("Inorder  : " + in);
        System.out.println("Postorder: " + post);
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}