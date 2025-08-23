package LinkedListL1;


public class MergeTwoSortedLL {
    // Utility: addLast (returns new tail)
    private static Node addLast(Node tail, int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (tail != null) {
            tail.next = temp;
        }
        return temp;
    }

    // Utility: display a list from given head
    public static void display(Node head) {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    // Merge two sorted linked lists
    public static Node mergeTwoSortedLists(Node one, Node two) {
        Node dummy = new Node();
        Node curr = dummy;

        while (one != null && two != null) {
            if (one.data < two.data) {
                curr.next = one;
                one = one.next;
            } else {
                curr.next = two;
                two = two.next;
            }
            curr = curr.next;
        }

        if (one != null) curr.next = one;
        if (two != null) curr.next = two;

        return dummy.next;
    }

    public static void main(String[] args) {
        // First Linked List
        Node head1 = null, tail1 = null;
        int[] arr1 = {10, 20, 30, 40, 50};
        for (int val : arr1) {
            if (head1 == null) {
                head1 = tail1 = new Node();
                head1.data = val;
            } else {
                tail1 = addLast(tail1, val);
            }
        }

        // Second Linked List
        Node head2 = null, tail2 = null;
        int[] arr2 = {7, 9, 12, 15, 37, 43, 44, 48, 52, 56};
        for (int val : arr2) {
            if (head2 == null) {
                head2 = tail2 = new Node();
                head2.data = val;
            } else {
                tail2 = addLast(tail2, val);
            }
        }

        // Merge the two sorted linked lists
        Node mergedHead = mergeTwoSortedLists(head1, head2);

        // Display merged list
        System.out.println("Merged List:");
        display(mergedHead);
    }

    public static class Node {
        int data;
        Node next;
    }
}
