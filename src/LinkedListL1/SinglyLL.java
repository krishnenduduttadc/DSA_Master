package LinkedListL1;

public class SinglyLL {

    Node head;

    public static void main(String[] args) {
        SinglyLL b = new SinglyLL();
        b.insertAtBeg(10);
        b.insertAtBeg(20);
        b.insertAtBeg(30);
        b.insertAtBeg(31);
        b.insertEnd(11);
        b.insertEnd(40);

        b.printList();
        b.insertEnd(50);
        System.out.println();
        b.printList();
        b.middleNode();
        b.printNthfromEnd(3);
        b.printList();
        System.out.println("\n-------------------");
        b.reverse();
        b.printList();
        System.out.println("Loop is present: " + b.detectLoop());
    }

    void insertAtBeg(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;

    }

    void insertEnd(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
    }

    void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    void middleNode() {
        Node fast = head, slow = head;
        if (head == null) {
            return;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println("\n" + slow.data + " is middle node");
    }

    void printNthfromEnd(int n) {
        int len = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            len++;
        }
        System.out.println(len);
        if (len < n) return;
        Node curr = head;
        for (int i = 0; i < len - n; i++) {
            curr = curr.next;
        }
        System.out.println("\n" + curr.data + " is " + n + "th node");
    }

    void reverse() {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    boolean detectLoop() {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    void detectandRemoveLoop() {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return;
        }
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    void deleteNodeOnePtr(Node ptr) {
        Node tmp = ptr.next;
        ptr.data = tmp.next.data;
        ptr.next = tmp.next.next;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }

    }
}
