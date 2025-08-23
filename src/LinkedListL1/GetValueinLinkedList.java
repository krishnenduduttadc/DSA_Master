package LinkedListL1;

public class GetValueinLinkedList {
    // Linked list state
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

    // Return size of list
    public static int size() {
        return size;
    }

    // Display elements
    public static void display() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    // Remove first node
    public static void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    // Get first element
    public static int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    // Get last element
    public static int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return tail.data;
        }
    }

    // Get element at index
    public static int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node t = head;
            for (int i = 0; i < idx; i++) {
                t = t.next;
            }
            return t.data;
        }
    }

    public static void main(String[] args) {
        // Hardcoded sequence of operations
        addLast(10);
        System.out.println(getFirst()); // Expected: 10

        addLast(20);
        addLast(30);
        System.out.println(getFirst()); // Expected: 10
        System.out.println(getLast());  // Expected: 30

        System.out.println(getAt(1));   // Expected: 20

        addLast(40);
        System.out.println(getLast());  // Expected: 40

        addLast(50);
        removeFirst();
        System.out.println(getFirst()); // Expected: 20

        removeFirst();
        removeFirst();
        System.out.println(getAt(3));   // Expected: Invalid arguments

        removeFirst();
        removeFirst();
        System.out.println(getFirst()); // Expected: List is empty

        display(); // Expected: List is empty
    }

    static class Node {
        int data;
        Node next;
    }
}
