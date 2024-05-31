package BSTL1;

public class ReplaceWithSumofLarger {
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

    static int sum = 0;
    public static void rwsol(Node node){
        // write your code here
        if(node==null){
            return;
        }
        rwsol(node.right);
        int od=node.data;
        node.data=sum;
        sum+=od;
        rwsol(node.left);
    }

    public static void main(String[] args) throws Exception {
        // Hardcode the binary search tree
        Node root = new Node(50,
                new Node(25,
                        new Node(12, null, null),
                        new Node(37, null, null)
                ),
                new Node(75,
                        new Node(62, null, null),
                        new Node(87, null, null)
                )
        );

        // Replace with sum of larger elements
        rwsol(root);

        // Display the updated BST
        display(root);
    }
}
