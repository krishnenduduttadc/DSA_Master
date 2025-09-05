package LeetCodePatterns.LinkedList;

public class Middle {

    public static void main(String[] args) {
        Middle solution = new Middle();

        // Example 1: Odd length -> [1,2,3,4,5]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        System.out.println("Middle node (odd length): " + solution.middleNode(head1).val);
        // Expected: 3
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
