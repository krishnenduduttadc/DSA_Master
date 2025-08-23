package LinkedListL1;

public class KReverse {

    // Print linked list
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Add node at the end
    static Node addLast(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // Reverse in groups of k
    static Node kReverse(Node head, int k) {
        if (head == null) return null;

        Node prev = null, curr = head, next = null;
        int count = 0;

        // Reverse first k nodes
        Node temp = head;
        int size = 0;
        while (temp != null) { // count total size
            size++;
            temp = temp.next;
        }

        if (size < k) return head; // If remaining < k, keep as is

        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Recursively reverse rest of the list
        if (next != null) {
            head.next = kReverse(next, k);
        }

        return prev;
    }

    public static void main(String[] args) {
        Node head = null;

        // Build list [1,2,3,4,5,6,7,8,9,10,11]
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int v : values) {
            head = addLast(head, v);
        }

        int k = 3;

        System.out.println("Before k-Reverse:");
        display(head);

        head = kReverse(head, k);

        System.out.println("After k-Reverse (k=" + k + "):");
        display(head);
    }

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }
}
