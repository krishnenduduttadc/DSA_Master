package LinkedListL1;

public class Mid {
    private static Node head;
    private static Node tail;
    private static int size;

    public static void addLast(int val) {
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


    private static Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) temp = temp.next;
        return temp;
    }

    // ========== Helpers ==========

    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }


    public static int mid() {
        Node s = head;
        Node f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s.data;
    }

    public static void main(String[] args) {
        addLast(10);
        addLast(20);
        addLast(30);
        addLast(40);
        addLast(50);
        System.out.println(mid());
    }
    
    public static class Node {
        int data;
        Node next;
    }
}
