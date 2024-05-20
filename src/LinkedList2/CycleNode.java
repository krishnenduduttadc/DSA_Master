package LinkedList2;

public class CycleNode {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node findCycleNode(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) break;
        }

        if (slow != fast) return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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

        // Find the start node of the cycle
        Node ans = findCycleNode(head);
        System.out.println(ans != null ? ans.val : -1);
    }
}
