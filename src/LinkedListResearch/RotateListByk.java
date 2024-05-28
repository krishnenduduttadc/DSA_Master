package LinkedListResearch;

public class RotateListByk {
     static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }
    public Node rotateRight(Node head, int k) {
        if (head == null || k == 0) return head;

        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        RotateListByk solution = new RotateListByk();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node result = solution.rotateRight(head, 2);
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
