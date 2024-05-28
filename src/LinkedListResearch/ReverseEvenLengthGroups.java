package LinkedListResearch;

public class ReverseEvenLengthGroups {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public Node reverseEvenLengthGroups(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node groupPrev = dummy;
        int groupSize = 1;

        while (head != null) {
            int count = 0;
            Node groupHead = head;

            while (count < groupSize && head != null) {
                head = head.next;
                count++;
            }

            if (count % 2 == 0) {
                Node reversedHead = reverse(groupHead, count);
                groupPrev.next = reversedHead;
                groupHead.next = head;
                groupPrev = groupHead;
            } else {
                groupPrev = head;
            }

            groupSize++;
        }

        return dummy.next;
    }

    private Node reverse(Node head, int k) {
        Node prev = null;
        while (k > 0) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            k--;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseEvenLengthGroups solution = new ReverseEvenLengthGroups();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        Node result = solution.reverseEvenLengthGroups(head);
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
