package LeetCodePatterns.LinkedList;

public class Intersection {

    public static void main(String[] args) {
        Intersection solution = new Intersection();

        // Create shared part: 8 -> 10
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        // List A: 3 -> 7 -> 8 -> 10
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = intersect;

        // List B: 99 -> 1 -> 8 -> 10
        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = intersect;

        ListNode result = solution.getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val); // Expected: 8
        } else {
            System.out.println("No intersection.");
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = findLength(headA);
        int n = findLength(headB);
        ListNode fp = null, sp = null;
        if (m <= n) {
            fp = headA;
            sp = headB;
            for (int i = 0; i < n - m; i++) {
                sp = sp.next;
            }
        } else {
            fp = headA;
            sp = headB;
            for (int i = 0; i < m - n; i++) {
                fp = fp.next;
            }
        }

        while (fp != null) {
            if (fp == sp) {
                return fp;
            }
            fp = fp.next;
            sp = sp.next;
        }

        return null;
    }

    public int findLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        return length;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}
