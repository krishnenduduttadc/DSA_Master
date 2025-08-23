package LinkedListL1;

public class Fold {
    // Linked list state
    static Node head;
    static Node tail;
    static int size;
    static Node fleft; // for fold helper

    // Add at the end
    public static void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    // Display the list
    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Recursive fold helper
    private static void foldHelper(Node right, int floor) {
        if (right == null) {
            return;
        }

        foldHelper(right.next, floor + 1);

        if (floor > size / 2) {
            Node temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        } else if (floor == size / 2) {
            tail = right;
            tail.next = null;
        }
    }

    // Fold function
    public static void fold() {
        fleft = head;
        foldHelper(head, 0);
    }

    public static void main(String[] args) {
        // Hardcoded linked list
        int[] values = {1, 2, 3, 4, 5};
        for (int val : values) {
            addLast(val);
        }

        System.out.println("Before fold:");
        display();

        fold();

        System.out.println("After fold:");
        display();
    }

    static class Node {
        int data;
        Node next;
    }
}
