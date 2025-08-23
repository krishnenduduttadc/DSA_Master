package LinkedListL1;

public class OddEven {
    private Node head;
    private Node tail;
    private int size;

    // ========== Main ==========
    public static void main(String[] args) {
        OddEven list = new OddEven();
        list.addLast(2);
        list.addLast(8);
        list.addLast(9);
        list.addLast(1);
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);

        System.out.print("Original List: ");
        list.display();

        list.oddEven();

        System.out.print("List after Odd-Even Segregation: ");
        list.display();
    }

    // ========== Basic Operations ==========
    public void addLast(int val) {
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
        }
        return head.data;
    }

    public int mid() {
        Node f = head;
        Node s = head;

        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s.data;
    }

    // ========== OddEven Function ==========
    public void oddEven() {
        OddEven odd = new OddEven();
        OddEven even = new OddEven();

        while (size > 0) {
            int val = getFirst();
            removeFirst();

            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            head = odd.head;
            tail = even.tail;
            size = odd.size + even.size;
        } else if (odd.size > 0) {
            head = odd.head;
            tail = odd.tail;
            size = odd.size;
        } else if (even.size > 0) {
            head = even.head;
            tail = even.tail;
            size = even.size;
        }
    }

    public static class Node {
        int data;
        Node next;
    }
}
