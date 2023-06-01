package Striver_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    Node node;
    int num;
    Pair(Node _node, int _num) {
        num = _num;
        node = _node;
    }
}
public class Pre_in_post {
    public static void allTraversal(Node root, List < Integer > pre, List < Integer > in , List < Integer > post) {
        Stack< Pair > st = new Stack < Pair > ();
        st.push(new Pair(root, 1));

        if (root == null) return;

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // this is part of pre
            // increment 1 to 2
            // push the left side of the tree
            if (it.num == 1) {
                pre.add(it.node.key);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // this is a part of in
            // increment 2 to 3
            // push right
            else if (it.num == 2) { in .add(it.node.key);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // don't push it back again
            else {
                post.add(it.node.key);
            }
        }


    }
    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List < Integer > pre = new ArrayList < > ();
        List < Integer > in = new ArrayList < > ();
        List< Integer > post = new ArrayList< >();
        allTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}
