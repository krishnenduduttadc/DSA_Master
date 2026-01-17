package LinkedListL1;

public class ReverseRec {

    static Node head;
    static int size;

    public static void reverseDI() {
        int li = 0;
        int ri = size - 1;

        while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
            li++;
            ri--;
        }
    }

    // helper needed ONLY for reverseDI
    private static Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // -------------------- main --------------------
    public static void main(String[] args) {

        // Manually creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        size = 5;
        reverseDI();
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
