package BinaryTreeL3;

public class IsSymmetrical {
    public static boolean isSymmetric(Node root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private static boolean isSymmetricHelp(Node left, Node right){
        if(left==null || right==null)
            return left==right;
        if(left.key!=right.key)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);


        boolean stat = isSymmetric(root);
        System.out.println(stat);
    }
}
