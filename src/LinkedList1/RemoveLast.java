package LinkedList1;

public class RemoveLast {
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

        public void addAt(int idx, int val) {
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

        public void removeLast() {
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
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

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
                list.addFirst(val);
            } else if (command.startsWith("display")) {
                list.display();
            } else if (command.startsWith("removeFirst")) {
                list.removeFirst();
            } else if (command.startsWith("size")) {
                System.out.println(list.size());
            } else if (command.startsWith("getFirst")) {
                int val = list.getFirst();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.startsWith("getLast")) {
                int val = list.getLast();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.startsWith("getAt")) {
                int idx = Integer.parseInt(command.split(" ")[1]);
                int val = list.getAt(idx);
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (command.startsWith("addAt")) {
                int idx = Integer.parseInt(command.split(" ")[1]);
                int val = Integer.parseInt(command.split(" ")[2]);
                list.addAt(idx, val);
            } else if (command.startsWith("removeLast")) {
                list.removeLast();
            } else if (command.equals("quit")) {
                break;
            }
        }
    }
}
