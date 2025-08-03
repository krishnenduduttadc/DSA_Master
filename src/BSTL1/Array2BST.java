package BSTL1;

import java.util.LinkedList;
import java.util.Queue;

public class Array2BST {

    public static Node SortedArrayToBST(int[] arr, int n) {
        return SortedArrayToBSThelper(arr, 0, n - 1);
    }

    public static Node SortedArrayToBSThelper(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = SortedArrayToBSThelper(arr, start, mid - 1);
        root.right = SortedArrayToBSThelper(arr, mid + 1, end);
        return root;
    }

    public static void printLevelWise(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.remove();
                System.out.print(front.data + " ");
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        Node t = SortedArrayToBST(arr, n);
        printLevelWise(t);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
