package LinkedList2;

public class Reverse {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode th = null;
    static ListNode tt = null;

    public static void addFirst(ListNode node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = null;
            addFirst(curr);

            curr = forw;
        }

        return th;
    }

    static ListNode head;

    void push(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    public static void main(String[] args) {

        Reverse llist = new Reverse();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        ListNode head1 = reverse(head);
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
}
