package LinkedListL1;

public class IsPalin {
    // ✅ Palindrome check
    private static Node pleft; // pointer from left

    public static void main(String[] args) {
        // Hardcoded list: 1 → 2 → 3 → 2 → 1
        Node head = null;
        head = addLast(head, 1);
        head = addLast(head, 2);
        head = addLast(head, 3);
        head = addLast(head, 2);
        head = addLast(head, 1);

        System.out.println("Is Palindrome? " + isPalindrome(head)); // true
    }

    // Insert at end
    public static Node addLast(Node head, int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (head == null) {
            return temp;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public static boolean isPalindrome(Node head) {
        pleft = head;
        return isPalindromeHelper(head);
    }

    private static boolean isPalindromeHelper(Node right) {
        if (right == null) return true;

        boolean res = isPalindromeHelper(right.next);
        if (!res) return false;

        if (pleft.data != right.data) return false;

        pleft = pleft.next;
        return true;
    }


    public static class Node {
        int data;
        Node next;
    }
}
