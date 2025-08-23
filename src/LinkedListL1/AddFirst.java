package LinkedListL1;

public class AddFirst {
    // Head, tail and size as class-level variables
    static Node head;
    static Node tail;
    static int size;

    // Add an element at the beginning
    public static void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;

        if (size == 0) {
            tail = temp;
        }
        size++;
    }

    // Display the linked list
    public static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Hardcoded inputs
        addFirst(10);
        addFirst(20);
        addFirst(30);

        System.out.println("Linked list after adding elements at the front:");
        display(); // Expected: 30 20 10
    }

    static class Node {
        int data;
        Node next;
    }
}
