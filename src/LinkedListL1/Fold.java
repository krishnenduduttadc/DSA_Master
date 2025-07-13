package LinkedListL1;

public class Fold {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();

        // Hardcoded linked list
        int[] values = {1, 2, 3, 4, 5};
        for (int val : values) {
            l1.addLast(val);
        }

        System.out.println("Before fold:");
        l1.display();

        l1.fold();

        System.out.println("After fold:");
        l1.display();
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        // Folding logic
        static Node fleft;
        Node head;
        Node tail;
        int size;

        // Add at the end
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

        // Display the list
        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        private void foldHelper(Node right, int floor) {
            if (right == null) {
                return;
            }

            foldHelper(right.next, floor + 1);

            if (floor > size / 2) {
                Node temp = fleft.next;
                fleft.next = right;
                right.next = temp;
                fleft = temp;
            } else if (floor == size / 2) {
                tail = right;
                tail.next = null;
            }
        }

        public void fold() {
            fleft = head;
            foldHelper(head, 0);
        }
    }
}
