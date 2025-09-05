package LeetCodePatterns.LinkedList;

public class Reverse {

    public ListNode newHead = null;

    public static void main(String[] args) {
        Reverse solution = new Reverse();

        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        // Reverse
        ListNode reversed = solution.reverseList(head);

        // Print reversed list
        System.out.print("Reversed List: ");
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode lastNode = reverse(head);
            lastNode.next = null;
        }
        return newHead;
    }

    public ListNode reverse(ListNode current) {
        if (current.next == null) {
            newHead = current;
            return current;
        } else {
            ListNode lastNode = reverse(current.next);
            lastNode.next = current;
            return current;
        }
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
