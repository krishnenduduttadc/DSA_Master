package LinkedListL1;

public class RemoveFirst {
    // Linked list fields
    static Node head;
    static Node tail;
    static int size;

    // Add value at the end
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

    // Display all elements
    public static void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    // Remove first element
    public static void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    // Return size
    public static int size() {
        return size;
    }

    public static void main(String[] args) {
        // Hardcoded commands
        String[] commands = {
                "addLast 10",
                "addLast 20",
                "addLast 30",
                "display",
                "removeFirst",
                "size",
                "addLast 40",
                "addLast 50",
                "removeFirst",
                "display",
                "size",
                "removeFirst",
                "removeFirst",
                "removeFirst",
                "removeFirst",
                "quit"
        };

        for (String command : commands) {
            if (command.startsWith("addLast")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                addLast(val);
            } else if (command.equals("display")) {
                display();
            } else if (command.equals("removeFirst")) {
                removeFirst();
            } else if (command.equals("size")) {
                System.out.println(size());
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
