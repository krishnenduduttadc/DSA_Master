package BinaryTreeL3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

    static List<Integer> inorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            ans.add(curr.key);
            curr = curr.right;
        }
        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println(inorder(root));
    }

    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }
}