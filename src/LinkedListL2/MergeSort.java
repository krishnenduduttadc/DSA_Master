package LinkedListL2;

public class MergeSort {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to sort the given linked list using Merge Sort
    static Node mergeSort(Node h1) {
        if (h1 == null || h1.next == null) return h1;
        Node m = mid(h1);
        Node h2 = m.next;
        m.next = null;

        Node t1 = mergeSort(h1);
        Node t2 = mergeSort(h2);
        Node t3 = merge(t1, t2);
        return t3;
    }

    // Function to find the middle of the linked list
    static Node mid(Node h) {
        Node s = h, f = h;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    // Function to merge two sorted linked lists
    static Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        Node ans = null, t = null;
        if (h1.data < h2.data) {
            ans = h1;
            t = h1;
            h1 = h1.next;
        } else {
            ans = h2;
            t = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                t.next = h1;
                t = t.next;
                h1 = h1.next;
            } else {
                t.next = h2;
                t = t.next;
                h2 = h2.next;
            }
        }
        if (h1 != null) t.next = h1;
        if (h2 != null) t.next = h2;

        return ans;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the merge sort on a linked list
    public static void main(String[] args) {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
