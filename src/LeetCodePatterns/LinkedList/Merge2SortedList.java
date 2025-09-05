package LeetCodePatterns.LinkedList;

public class Merge2SortedList {

    public static void main(String[] args) {
        Merge2SortedList solution = new Merge2SortedList();
        // List1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // List2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        // Merge
        ListNode merged = solution.mergeTwoLists(list1, list2);
        // Print merged list
        System.out.print("Merged List: ");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Expected: 1 1 2 3 4 4
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = list1, second = list2;
        ListNode head = null, tail = null;
        while (first != null || second != null) {
            ListNode nodeToCopy = null;
            if (first != null && second != null) {
                if (first.val < second.val) {
                    nodeToCopy = first;
                    first = first.next;
                } else {
                    nodeToCopy = second;
                    second = second.next;
                }
            } else if (first != null) {
                nodeToCopy = first;
                first = first.next;
            } else {
                nodeToCopy = second;
                second = second.next;
            }

            tail = insert(tail, nodeToCopy.val);
            if (head == null) {
                head = tail;
            }

        }

        return head;

    }

    public ListNode insert(ListNode tail, int data) {
        ListNode ntbi = new ListNode(data, null);

        if (tail != null) {
            tail.next = ntbi;
        }

        return ntbi;
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
