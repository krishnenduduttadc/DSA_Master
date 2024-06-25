package LinkedListL1;

public class RemoveFirst {
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
                head = null;
                tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

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
                list.addLast(val);
            } else if (command.startsWith("display")) {
                list.display();
            } else if (command.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (command.startsWith("size")) {
                System.out.println(list.size());
            } else if (command.equals("quit")) {
                break;
            }
        }
    }
}
