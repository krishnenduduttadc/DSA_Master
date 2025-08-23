package LinkedListL1;

public class ReverseIter {
    // LinkedList fields
    static Node head;
    static Node tail;
    static int size;

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

    // -------------------- Core Methods --------------------

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

    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
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

    // Reverse by swapping data
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

    // Reverse by changing pointers
    public static void reversePI() {
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

    public static int size() {
        return size;
    }

    // -------------------- Main --------------------
    public static void main(String[] args) {
        // Hardcoded commands
        String[] commands = {
                "addFirst 10",
                "addFirst 20",
                "addLast 30",
                "addLast 40",
                "addLast 50",
                "addFirst 60",
                "removeAt 2",
                "display",
                "reversePI",
                "display",
                "quit"
        };

        for (String command : commands) {
            if (command.startsWith("addFirst")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                addFirst(val);
            } else if (command.startsWith("addLast")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                addLast(val);
            } else if (command.startsWith("display")) {
                display();
            } else if (command.startsWith("removeFirst")) {
                removeFirst();
            } else if (command.startsWith("size")) {
                System.out.println(size());
            } else if (command.startsWith("getFirst")) {
                int val = getFirst();
                if (val != -1) System.out.println(val);
            } else if (command.startsWith("getLast")) {
                int val = getLast();
                if (val != -1) System.out.println(val);
            } else if (command.startsWith("getAt")) {
                int idx = Integer.parseInt(command.split(" ")[1]);
                int val = getAt(idx);
                if (val != -1) System.out.println(val);
            } else if (command.startsWith("addAt")) {
                int idx = Integer.parseInt(command.split(" ")[1]);
                int val = Integer.parseInt(command.split(" ")[2]);
                addAt(idx, val);
            } else if (command.startsWith("removeLast")) {
                removeLast();
            } else if (command.startsWith("removeAt")) {
                int idx = Integer.parseInt(command.split(" ")[1]);
                removeAt(idx);
            } else if (command.startsWith("reverseDI")) {
                reverseDI();
            } else if (command.startsWith("reversePI")) {
                reversePI();
            } else if (command.equals("quit")) {
                break;
            }
        }
    }

    // Allowed inner class
    public static class Node {
        int data;
        Node next;
    }
}
