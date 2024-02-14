/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreeL1;



/**
 *
 * @author krish
 */
public class LCA {

    static int getLCA(Node root, int a, int b) {

        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
         */
        Node node = getLCA2(root, a, b);
        return node.data;

    }

    static Node getLCA2(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node lca1 = getLCA2(root.left, n1, n2);
        Node lca2 = getLCA2(root.right, n1, n2);

        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        System.out.println("" + getLCA(root, 3, 7));
    }
}
