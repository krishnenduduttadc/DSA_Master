package LinkedListL1;

public class RemoveDuplicates {
    // Add a new node at the end
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

    // Display the list
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Remove duplicates from sorted list
    public static Node removeDuplicates(Node head) {
        if (head == null) return null;

        Node dummy = new Node();
        Node resTail = dummy;
        Node curr = head;

        while (curr != null) {
            if (resTail == dummy || resTail.data != curr.data) {
                resTail.next = curr;
                resTail = resTail.next;
            }
            curr = curr.next;
        }
        resTail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Hardcoded input
        int[] elements = {2, 2, 2, 3, 3, 5, 5, 5, 5, 5};

        Node head = null;
        for (int element : elements) {
            head = addLast(head, element);
        }

        System.out.println("Original List:");
        display(head);

        head = removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        display(head);
    }

    // Only allowed inner class
    public static class Node {
        int data;
        Node next;
    }
}
