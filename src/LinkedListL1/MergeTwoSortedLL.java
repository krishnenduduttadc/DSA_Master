package LinkedListL1;

public class MergeTwoSortedLL {
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

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
            Node one = l1.head;
            Node two = l2.head;

            LinkedList res = new LinkedList();
            while (one != null && two != null) {
                if (one.data < two.data) {
                    res.addLast(one.data);
                    one = one.next;
                } else {
                    res.addLast(two.data);
                    two = two.next;
                }
            }

            while (one != null) {
                res.addLast(one.data);
                one = one.next;
            }

            while (two != null) {
                res.addLast(two.data);
                two = two.next;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        // Create the first linked list
        LinkedList l1 = new LinkedList();
        l1.addLast(10);
        l1.addLast(20);
        l1.addLast(30);
        l1.addLast(40);
        l1.addLast(50);

        // Create the second linked list
        LinkedList l2 = new LinkedList();
        l2.addLast(7);
        l2.addLast(9);
        l2.addLast(12);
        l2.addLast(15);
        l2.addLast(37);
        l2.addLast(43);
        l2.addLast(44);
        l2.addLast(48);
        l2.addLast(52);
        l2.addLast(56);

        // Merge the two sorted linked lists
        LinkedList merged = LinkedList.mergeTwoSortedLists(l1, l2);

        // Display the merged list
        System.out.println("Merged List:");
        merged.display();
    }
}
