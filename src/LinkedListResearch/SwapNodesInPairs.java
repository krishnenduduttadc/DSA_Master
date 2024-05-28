package LinkedListResearch;

public class SwapNodesInPairs {
    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
    public Node swapPairs(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        while (current.next != null && current.next.next != null) {
            Node first = current.next;
            Node second = current.next.next;

            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node result = solution.swapPairs(head);
        printList(result);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
