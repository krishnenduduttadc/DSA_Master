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

    // ========== Basic Operations ==========

    public static void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;

        if (size == 0) {
            tail = temp;
        }
        size++;
    }

    public static void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            addFirst(val);
        } else if (idx == size) {
            addLast(val);
        } else {
            Node node = new Node();
            node.data = val;

            Node temp = head;
            for (int i = 0; i < idx - 1; i++) temp = temp.next;

            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public static void removeFirst() {
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

    public static void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) temp = temp.next;

            tail = temp;
            tail.next = null;
            size--;
        }
    }

    public static void removeAt(int idx) {
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
        } else if (idx == 0) {
            removeFirst();
        } else if (idx == size - 1) {
            removeLast();
        } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) temp = temp.next;

            temp.next = temp.next.next;
            size--;
        }
    }

    public static int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    // ========== Getters ==========

    public static int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    public static int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) temp = temp.next;
            return temp.data;
        }
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

    // Reverse data iterative
    public static void reverseDI() {
        int li = 0, ri = size - 1;
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

    // Reverse pointers iterative
    public static void reversePI() {
        if (size <= 1) return;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node temp = head;
        head = tail;
        tail = temp;
    }

    public static int kthFromLast(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) fast = fast.next;

        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
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
        display();

        System.out.println(getFirst());

        addLast(20);
        addLast(30);

        System.out.println(getFirst());
        System.out.println(getLast());
        System.out.println(getAt(1));

        addLast(40);

        System.out.println(mid());
        System.out.println(getLast());

        addLast(50);
        removeFirst();
        System.out.println(getFirst());

        removeFirst();
        removeFirst();
        System.out.println(mid());

        removeFirst();
        removeFirst();
        System.out.println(getFirst());
    }

    // ========== Main for testing ==========

    public static class Node {
        int data;
        Node next;
    }
}
