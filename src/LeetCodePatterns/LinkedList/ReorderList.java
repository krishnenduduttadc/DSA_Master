package LeetCodePatterns.LinkedList;

public class ReorderList {
    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        // Example 1: [1,2,3,4] -> [1,4,2,3]
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        solution.reorderList(head1);
        printList(head1); // Expected: 1 -> 4 -> 2 -> 3
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode secondHalf = slow.next;
        slow.next = null;

        // Step 2: Reverse the second half
        secondHalf = reverseList(secondHalf);

        // Step 3: Merge the first half with the reversed second half
        ListNode current = head;
        while (secondHalf != null) {
            ListNode nextFirst = current.next;
            ListNode nextSecond = secondHalf.next;

            current.next = secondHalf;
            secondHalf.next = nextFirst;

            current = nextFirst;
            secondHalf = nextSecond;
        }
    }

    // Helper function to reverse a linked list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
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
