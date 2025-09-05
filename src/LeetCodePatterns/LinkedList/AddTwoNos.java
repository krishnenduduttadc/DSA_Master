package LeetCodePatterns.LinkedList;

public class AddTwoNos {

    public static void main(String[] args) {
        AddTwoNos solution = new AddTwoNos();

        // Example 1: l1 = [2,4,3], l2 = [5,6,4]
        // Expected result: [7,0,8] (since 342 + 465 = 807)
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        printList(result1); // Expected: 7 -> 0 -> 8
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = head;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            int val = sum % 10;
            carry = sum / 10;

            if (current == null) {
                head = new ListNode(val);
                current = head;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

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
