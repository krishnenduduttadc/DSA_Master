package LinkedListL1;

public class Intersection {
    // Linked list state
    static Node head;
    static Node tail;
    static int size;

    // Add methods
    public static void addLast(int val) {
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
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    // Remove methods
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
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
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
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    // Get methods
    public static int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

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
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    private static Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Display
    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static int size() {
        return size;
    }

    // ---- Intersection Logic ----
    public static int findIntersection(Node h1, int size1, Node h2, int size2) {
        Node t1 = h1;
        Node t2 = h2;

        int delta = Math.abs(size1 - size2);
        if (size1 > size2) {
            for (int i = 0; i < delta; i++) {
                t1 = t1.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                t2 = t2.next;
            }
        }

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1.data;
    }

    // ---- Main ----
    public static void main(String[] args) {
        // First linked list
        Node h1 = null, t1 = null;
        int[] values1 = {1, 2, 3, 4, 5};
        for (int val : values1) {
            Node n = new Node();
            n.data = val;
            if (h1 == null) {
                h1 = t1 = n;
            } else {
                t1.next = n;
                t1 = n;
            }
        }
        int size1 = values1.length;

        // Second linked list
        Node h2 = null, t2 = null;
        int[] values2 = {11, 22, 33, 44, 55, 66, 77, 88};
        for (int val : values2) {
            Node n = new Node();
            n.data = val;
            if (h2 == null) {
                h2 = t2 = n;
            } else {
                t2.next = n;
                t2 = n;
            }
        }
        int size2 = values2.length;

        // Creating intersection manually
        int li = 2; // list chosen
        int di = 3; // index for intersection
        if (li == 1) {
            Node n = h1;
            for (int i = 0; i < di; i++) n = n.next;
            t2.next = n;
            t2 = t1;
            size2 += (size1 - di);
        } else {
            Node n = h2;
            for (int i = 0; i < di; i++) n = n.next;
            t1.next = n;
            t1 = t2;
            size1 += (size2 - di);
        }

        // Find intersection
        int inter = findIntersection(h1, size1, h2, size2);
        System.out.println(inter);  // Expected: intersection value
    }

    static class Node {
        int data;
        Node next;
    }
}
