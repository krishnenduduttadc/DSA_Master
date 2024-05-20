package LinkedList2;

public class Palindrome {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node midNode(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node reverseOfLL(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node curr = head;
        Node forw = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        // Find the middle of the linked list
        Node mid = midNode(head);

        // Reverse the second half of the list
        Node nHead = mid.next;
        mid.next = null;  // Split the list into two halves
        nHead = reverseOfLL(nHead);

        // Compare the two halves
        Node c1 = head;
        Node c2 = nHead;

        boolean res = true;
        while (c2 != null) {  // Only need to compare until c2 ends
            if (c1.val != c2.val) {
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        // Restore the original list
        nHead = reverseOfLL(nHead);
        mid.next = nHead;
        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head)); // should print true
    }
}
