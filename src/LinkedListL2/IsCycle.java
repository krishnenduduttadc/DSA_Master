package LinkedListL2;

public class IsCycle {

    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static boolean isCyclePresentInLL(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Creating a cycle by pointing the next of last node to the node with value 3 (index 2)
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node cycleNode = head.next.next; // Node with value 3
        tail.next = cycleNode;

        // Check if the cycle is present
        System.out.println(isCyclePresentInLL(head));  // Should print true if cycle is present
    }
}