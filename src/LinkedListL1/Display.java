package LinkedListL1;

public class Display {
    // Linked list state variables
    static Node head;
    static Node tail;
    static int size;

    // Add element at the end
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

    // Return size of the list
    public static int size() {
        return size;
    }

    // Display elements of the list
    public static void display() {
        Node t = head;
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded sequence of operations
        addLast(10);
        addLast(20);
        addLast(30);
        display(); // Expected: 10 20 30
        System.out.println(size()); // Expected: 3

        addLast(40);
        addLast(50);
        display(); // Expected: 10 20 30 40 50
        System.out.println(size()); // Expected: 5
    }

    static class Node {
        int data;
        Node next;
    }
}
