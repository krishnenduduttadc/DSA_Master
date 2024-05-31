package BSTL1;

public class SizeSumMaxMinFind {
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

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    public static int size(Node node) {
        // write your code here
        if(node==null){
            return 0;
        }
        int ls=size(node.left);
        int rs=size(node.right);
        return ls+rs+1;
    }

    public static int sum(Node node) {
        // write your code here
        if(node==null){
            return 0;
        }
        int ls=sum(node.left);
        int rs=sum(node.right);
        return ls+rs+node.data;
    }

    public static int max(Node node) {
        // write your code here
        if(node.right!=null){
            return max(node.right);
        }else{
            return node.data;
        }
    }

    public static int min(Node node) {
        // write your code here
        if(node.left!=null){
            return min(node.left);
        }else{
            return node.data;
        }
    }

    public static boolean find(Node node, int data){
        // write your code here
        if(node==null){
            return false;
        }
        if(data>node.data){
            return find(node.right,data);
        }else if(data<node.data){
            return find(node.left,data);
        }else{
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // Hardcode the binary search tree
        Node root = new Node(50,
                new Node(25,
                        new Node(12, null, null),
                        new Node(37,
                                new Node(30, null, null),
                                null
                        )
                ),
                new Node(75,
                        new Node(62, null, null),
                        new Node(87, null, null)
                )
        );

        // Read the data to find from input
        int data = 6;//Integer.parseInt(br.readLine());

        // Perform operations on the BST
        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, data);

        // Print the results
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);
    }
}
