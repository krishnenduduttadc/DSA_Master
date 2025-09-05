package LeetCodePatterns.LinkedList;

public class Cycle {

    public static void main(String[] args) {
        Cycle solution = new Cycle();
        // List 1: 3 -> 2 -> 0 -> -4 -> (points back to 2, cycle)
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // create cycle at node 2
        System.out.println("Has cycle (list1): " + solution.hasCycle(head1)); // Expected: true
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head, second = head;

        do {
            first = first.next;
            second = second.next.next;

            if (first == second) {
                return true;
            }

        } while (first != null && second != null && second.next != null);

        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
