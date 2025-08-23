package LinkedListL1;

public class AddLast {
    // Class-level variables for linked list
    static Node head;
    static Node tail;
    static int size;

    // Add an element at the end
    public static void addLast(int val) {
        Node n = new Node();
        n.data = val;
        n.next = null;

        if (size == 0) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    // Print the linked list + size + tail data
    public static void testList() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(size);

        if (size > 0) {
            System.out.println(tail.data);
        }
    }

    public static void main(String[] args) throws Exception {
        // Hardcoded sequence of addLast operations
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(50);

        // Test the list to see if the operations worked correctly
        testList();
    }

    static class Node {
        int data;
        Node next;
    }
}
