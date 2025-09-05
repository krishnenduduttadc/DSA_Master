package LeetCodePatterns.LinkedList;

public class RemoveNthfromEnd {

    public static void main(String[] args) {
        RemoveNthfromEnd solution = new RemoveNthfromEnd();

        // Example 1: [1,2,3,4,5], n=2 -> [1,2,3,5]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        head1 = solution.removeNthFromEnd(head1, 2);
        printList(head1); // Expected: 1 -> 2 -> 3 -> 5
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
