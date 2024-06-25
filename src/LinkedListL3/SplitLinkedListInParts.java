package LinkedListL3;

public class SplitLinkedListInParts {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

    public Node[] splitListToParts(Node root, int k) {
        Node[] parts = new Node[k];
        int length = 0;
        Node temp = root;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int n = length / k, r = length % k;
        Node current = root, prev = null;

        for (int i = 0; i < k; i++) {
            parts[i] = current;
            for (int j = 0; j < n + (i < r ? 1 : 0); j++) {
                prev = current;
                current = current.next;
            }
            if (prev != null) prev.next = null;
        }

        return parts;
    }
    public static void main(String[] args) {
        SplitLinkedListInParts solution = new SplitLinkedListInParts();

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);

        printList(head);
        Node[] result = solution.splitListToParts(head, 3);
        for (Node part : result) {
            printList(part);
        }
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
