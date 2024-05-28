package LinkedListResearch;

public class OddEvenLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
    public Node oddEvenList(Node head) {
        if (head == null) return null;

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = solution.oddEvenList(head);
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
