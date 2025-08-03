package BSTL1;

public class ElementsinRange {

    public static void elementsInRangeK1K2(Node root, int k1, int k2) {
        if (root == null) return;

        if (root.data > k1) {
            elementsInRangeK1K2(root.left, k1, k2);
        }

        if (root.data >= k1 && root.data <= k2) {
            System.out.println(root.data);
        }

        if (root.data < k2) {
            elementsInRangeK1K2(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        System.out.println("Elements in range [5, 8]:");
        elementsInRangeK1K2(root, 5, 8);
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
