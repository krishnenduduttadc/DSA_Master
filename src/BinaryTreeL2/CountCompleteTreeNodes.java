package BinaryTreeL2;

public class CountCompleteTreeNodes {
    public static class Node {
        int val;
        Node left, right;

        Node(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println("Number of nodes: " + solution.countNodes(root));  // Output: 6
    }

    public int countNodes(Node root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);
        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getHeight(Node node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            node = isLeft ? node.left : node.right;
        }
        return height;
    }

//    private int getHeight(Node node) {
//        if (node == null) {
//            return 0;
//        }
//        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
//    }
}
