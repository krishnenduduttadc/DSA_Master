package Striver_tree;

public class LCA {
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        Node r=lowestCommonAncestor(root,root.left.right,root.left.left.left);
        System.out.println(r.key);
    }
}
