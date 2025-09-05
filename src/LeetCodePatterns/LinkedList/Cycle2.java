package LeetCodePatterns.LinkedList;

public class Cycle2 {

    public static void main(String[] args) {
        Cycle2 solution = new Cycle2();

        // Example 1: List with cycle
        // 3 -> 2 -> 0 -> -4 -> back to node 2
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next; // create cycle

        ListNode cycleStart1 = solution.detectCycle(head1);
        System.out.println("Cycle starts at node: " +
                (cycleStart1 != null ? cycleStart1.val : "null"));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode insPoint = null;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                insPoint = slow;
                break;
            }
        }

        ListNode start = head;
        while (start != insPoint) {
            start = start.next;
            insPoint = insPoint.next;
        }

        return start;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
