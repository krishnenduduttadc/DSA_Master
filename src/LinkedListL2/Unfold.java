package LinkedListL2;

public class Unfold {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        Node forw = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static void unfold(Node head) {
        if (head == null || head.next == null) return;

        Node fh = head;
        Node fp = fh;

        Node sh = head.next;
        Node sp = sh;

        while (sp != null && sp.next != null) {
            Node f = sp.next;

            fp.next = f;
            sp.next = f.next;

            fp = fp.next;
            sp = sp.next;
        }

        fp.next = null;

        sh = reverse(sh);
        fp.next = sh;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Hardcoding the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        // Unfolding the list
        unfold(head);

        // Printing the unfolded list
        printList(head);
    }
}
