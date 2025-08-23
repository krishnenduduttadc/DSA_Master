package LinkedListL1;

public class KthNodeFromEnd {
    // head, tail, size
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

    // print list
    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    // remove first element
    public static void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    // get first element
    public static int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    // kth node from last
    public static int kthFromLast(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                System.out.println("List size is less than k");
                return -1;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        // Adding elements to the list
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(50);

        // Displaying the list
        System.out.println("Original list:");
        display();

        // Getting the value of the kth node from the end
        int k = 3;
        int kthValue = kthFromLast(k);
        if (kthValue != -1) {
            System.out.println("Value of the " + k + "th node from the end: " + kthValue);
        }
    }

    public static class Node {
        int data;
        Node next;
    }
}
