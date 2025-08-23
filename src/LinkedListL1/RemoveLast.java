package LinkedListL1;

public class RemoveLast {
    // Linked list fields
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

    public static int size() {
        return size;
    }

    public static void main(String[] args) {
        // Hardcoded commands
        String[] commands = {
                "addFirst 10",
                "getFirst",
                "addAt 0 20",
                "getFirst",
                "getLast",
                "display",
                "size",
                "addAt 2 40",
                "getLast",
                "addAt 1 50",
                "addFirst 30",
                "removeFirst",
                "getFirst",
                "removeLast",
                "removeLast",
                "addAt 2 60",
                "display",
                "size",
                "removeFirst",
                "removeLast",
                "getFirst",
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
            } else if (command.startsWith("removeLast")) {
                removeLast();
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
            } else if (command.equals("quit")) {
                break;
            }
        }
    }

    // -------------------- Main --------------------

    // Allowed inner class
    public static class Node {
        int data;
        Node next;
    }
}
