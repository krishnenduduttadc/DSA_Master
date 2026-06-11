package BinaryTreeL3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorder {

    static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            ans.add(curr.key);
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
        }
        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(preorder(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}