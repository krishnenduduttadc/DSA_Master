package LinkedListL1;

public class RemoveLast {

    static Node head;
    static Node tail;
    static int size;

    // -------------------- removeLast --------------------
    public static void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }

    // -------------------- main --------------------
    public static void main(String[] args) {

        // Manually creating linked list: 10 -> 20 -> 30
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        tail = head.next.next;
        size = 3;

        removeLast(); // removes 30
        removeLast(); // removes 20

        // Display remaining list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("\nSize = " + size);
    }

    // -------------------- Node --------------------
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
