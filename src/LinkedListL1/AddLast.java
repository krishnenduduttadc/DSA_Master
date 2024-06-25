package LinkedListL1;

public class AddLast {
    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node n = new Node();
            n.data = val;
            n.next = null;
            if (size == 0) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                tail = n;
            }
            size++;
        }
    }

    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
        System.out.println(list.size);

        if (list.size > 0) {
            System.out.println(list.tail.data);
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();

        // Hardcoded sequence of addLast operations
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        // Test the list to see if the operations worked correctly
        testList(list);
    }
}
