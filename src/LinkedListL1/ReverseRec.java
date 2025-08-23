package LinkedListL1;

public class ReverseRec {
    // Fields
    private Node head;
    private Node tail;
    private int size;

    // ------------------ Demo ------------------
    public static void main(String[] args) {
        ReverseRec list = new ReverseRec();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.print("Original List: ");
        list.display();

        System.out.print("Reverse Display: ");
        list.displayReverse();

        System.out.print("Reversing List using Recursion (PR): ");
        list.reversePR();
        list.display();

        System.out.print("Reversing List using Iteration (PI): ");
        list.reversePI();
        list.display();

        System.out.println("Mid element: " + list.mid());
        System.out.println("2nd from last: " + list.kthFromLast(2));
    }

    // ------------------ Basic Operations ------------------
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

    public void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;
        if (size == 0) tail = temp;
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
            for (int i = 0; i < idx - 1; i++) temp = temp.next;
            node.next = temp.next;
            temp.next = node;
            size++;
        }
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

    public void removeLast() {
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

    public void removeAt(int idx) {
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

    public int getFirst() {
        return size == 0 ? -1 : head.data;
    }

    public int getLast() {
        return size == 0 ? -1 : tail.data;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= size) return -1;
        Node temp = head;
        for (int i = 0; i < idx; i++) temp = temp.next;
        return temp.data;
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

    private Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) temp = temp.next;
        return temp;
    }

    // ------------------ Reverse Methods ------------------
    public void reverseDI() {
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

    public void reversePI() {
        Node prev = null, curr = head;
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

    private void reversePRHelper(Node node) {
        if (node == null) return;
        reversePRHelper(node.next);
        if (node != tail) node.next.next = node;
    }

    public void reversePR() {
        reversePRHelper(head);
        head.next = null;
        Node temp = head;
        head = tail;
        tail = temp;
    }

    private void displayReverseHelper(Node node) {
        if (node == null) return;
        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }

    public void displayReverse() {
        displayReverseHelper(head);
        System.out.println();
    }

    // ------------------ Advanced ------------------
    public int kthFromLast(int k) {
        Node slow = head, fast = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public int mid() {
        Node f = head, s = head;
        while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s.data;
    }

    // ✅ Only Node is allowed as inner class
    public static class Node {
        int data;
        Node next;
    }
}
