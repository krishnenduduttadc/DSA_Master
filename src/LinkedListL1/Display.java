package LinkedListL1;

public class Display {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
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

        public int size() {
            return size;
        }

        public void display() {
            Node t = head;
            while (t != null) {
                System.out.print(t.data + " ");
                t = t.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();

        // Hardcoded sequence of operations
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display(); // Should display: 10 20 30
        System.out.println(list.size()); // Should display: 3

        list.addLast(40);
        list.addLast(50);
        list.display(); // Should display: 10 20 30 40 50
        System.out.println(list.size()); // Should display: 5
    }
}
