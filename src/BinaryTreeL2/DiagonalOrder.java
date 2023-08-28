package BinaryTreeL2;

import java.util.ArrayList;
import java.util.LinkedList;

public class DiagonalOrder {
    static Node root;
    public static int cameras = 0;

    static class Node {
        int val;
        Node left, right;

        public Node(int item) {
            val = item;
            left = right = null;
        }
    }

    public static ArrayList<ArrayList<Integer>> diagonalOrder(Node root) {
        LinkedList<Node> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        que.addLast(root);
        while (que.size() != 0) {
            int size = que.size();
            ArrayList<Integer> smallAns = new ArrayList<>();
            while (size-- > 0) {
                Node rn = que.removeFirst();
                while (rn != null) {
                    smallAns.add(rn.val);
                    if (rn.left != null) que.addLast(rn.left);

                    rn = rn.right;
                }
            }

            ans.add(smallAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        DiagonalOrder tree = new DiagonalOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        System.out.println(ans);
    }
}
