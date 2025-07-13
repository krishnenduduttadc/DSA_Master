package LinkedListL1;

public class AddFirst {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Hardcoded inputs
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        System.out.println("Linked list after adding elements at the front:");
        list.display(); // Expected: 30 20 10
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        // Add an element at the beginning
        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }
            size++;
        }

        // Display the linked list
        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
