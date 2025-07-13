package LinkedListL1;

public class IsPalin {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Hardcoded list: 1 → 2 → 3 → 2 → 1
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        System.out.println("Is Palindrome? " + list.isPalindrome()); // true
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        // Check if the linked list is a palindrome
        static Node pleft;
        Node head;
        Node tail;
        int size;

        // Add element at the end
        public void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public boolean isPalindrome() {
            pleft = head;
            return isPalindromeHelper(head);
        }

        private boolean isPalindromeHelper(Node right) {
            if (right == null) return true;

            boolean res = isPalindromeHelper(right.next);
            if (!res) return false;

            if (pleft.data != right.data) return false;

            pleft = pleft.next;
            return true;
        }
    }
}
