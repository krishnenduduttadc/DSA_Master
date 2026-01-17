package LinkedListL1;

public class ReverseIter {

    static Node head;
    static Node tail;
    static int size;
    
    public static void reversePI() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // swap head and tail
        Node temp = head;
        head = tail;
        tail = temp;
    }

    // -------------------- main --------------------
    public static void main(String[] args) {

        // Manually creating linked list: 10 -> 20 -> 30 -> 40
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        tail = head.next.next.next;
        size = 4;
        reversePI();
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
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
