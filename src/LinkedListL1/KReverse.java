package LinkedListL1;

public class KReverse {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Hardcoded input using addLast only
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int val : values) {
            list.addLast(val);
        }

        int k = 3;

        System.out.println("Before k-Reverse:");
        list.display();

        list.kReverse(k);

        System.out.println("After k-Reverse (k=" + k + "):");
        list.display();
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head, tail;
        int size;

        // Add node at end
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        // Get first node data
        int getFirst() {
            return head != null ? head.data : -1;
        }

        // Remove first node
        void removeFirst() {
            if (head != null) {
                head = head.next;
                size--;
                if (size == 0) tail = null;
            }
        }

        // Print the list
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // K-Group Reverse
        void kReverse(int k) {
            LinkedList prev = null;

            while (this.size > 0) {
                LinkedList curr = new LinkedList();

                if (this.size >= k) {
                    for (int i = 0; i < k; i++) {
                        int val = this.getFirst();
                        this.removeFirst();
                        // Reverse within group
                        Node temp = new Node();
                        temp.data = val;
                        temp.next = curr.head;
                        curr.head = temp;
                        if (curr.size == 0) curr.tail = temp;
                        curr.size++;
                    }
                } else {
                    while (this.size > 0) {
                        int val = this.getFirst();
                        this.removeFirst();
                        curr.addLast(val);
                    }
                }

                if (prev == null) {
                    prev = curr;
                } else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size += curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }
    }
}
