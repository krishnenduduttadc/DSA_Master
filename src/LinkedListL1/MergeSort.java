package LinkedListL1;

public class MergeSort {
    private static Node head;
    private static Node tail;
    private static int size;

    // add element at end
    public static void addLast(int val) {
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

    // display list
    public static void display(Node node) {
        for (Node temp = node; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    // merge two sorted lists
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

    // find middle node between head and tail
    public static Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;

        while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    // merge sort implementation
    public static Node mergeSort(Node head, Node tail) {
        if (head == tail) {
            Node br = new Node();
            br.data = head.data;
            br.next = null;
            return br;
        }

        Node mid = midNode(head, tail);
        Node fsh = mergeSort(head, mid);
        Node ssh = mergeSort(mid.next, tail);

        return mergeTwoSortedLists(fsh, ssh);
    }

    public static void main(String[] args) {
        // Adding elements to the list
        addLast(10);
        addLast(2);
        addLast(19);
        addLast(22);
        addLast(3);
        addLast(7);

        // Performing merge sort
        Node sortedHead = mergeSort(head, tail);

        // Displaying the sorted list
        System.out.println("Sorted list:");
        display(sortedHead);
    }

    public static class Node {
        int data;
        Node next;
    }
}
