package LinkedListL1;

public class AddFirst {
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
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
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

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

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
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(10);
        System.out.println(list.getFirst()); // 10

        list.addFirst(20);
        System.out.println(list.getFirst()); // 20
        System.out.println(list.getLast());  // 10

        list.display(); // 20 10
        System.out.println(list.size()); // 2

        list.addLast(40);
        System.out.println(list.getLast()); // 40

        list.addLast(50);
        list.addFirst(30);
        list.removeFirst();
        System.out.println(list.getFirst()); // 20

        list.removeFirst();
        list.removeFirst();
        System.out.println(list.getAt(1)); // 40

        list.display(); // 40 50
        System.out.println(list.size()); // 2

        list.removeFirst();
        list.removeFirst();
        System.out.println(list.getFirst()); // List is empty, -1
    }
}
