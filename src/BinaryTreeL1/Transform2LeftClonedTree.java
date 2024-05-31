package BinaryTreeL1;

public class Transform2LeftClonedTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node createLeftCloneTree(Node node){
        // write your code here
        if(node==null){
            return null;
        }
        Node lcr=createLeftCloneTree(node.left);
        Node rcr=createLeftCloneTree(node.right);
        Node nl=new Node(node.data,lcr,null);
        node.left=nl;
        node.right=rcr;
        return node;
    }

    public static void main(String[] args) {
        // Hardcoded tree construction
        Node root = new Node(50, null, null);
        root.left = new Node(25, null, null);
        root.left.left = new Node(12, null, null);
        root.left.right = new Node(37, null, null);
        root.right = new Node(75, null, null);
        root.right.left = new Node(62, null, null);
        root.right.right = new Node(87, null, null);

        root = createLeftCloneTree(root);
        display(root);
    }
}
