package LinkedListL1;

public class AddAtIndex {

    static Node head, tail;
    static int size = 0;

    public static void main(String[] args) {

        addFirst(10);
        addAt(0, 20);
        addAt(2, 40);
        addAt(1, 50);
        addFirst(30);
        addAt(2, 60);
        display();


    }

    static void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (size == 0) {
            tail = node;
        }
        size++;
    }

    // ===== Linked List Methods =====

    static void addLast(int val) {
        Node node = new Node(val);

        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    static void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node node = new Node(val);
            Node temp = head;

            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }


    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
