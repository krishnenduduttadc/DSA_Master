package LinkedListL1;

public class DoublyLL {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d) {
            this.data = d;
        }
    }
    Node head;

    void insertAtBeg(int x) {
        Node temp = new Node(x);
        temp.next = head;
        temp.prev = null;
        head = temp;
    }

    void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        DoublyLL b = new DoublyLL();
        b.insertAtBeg(10);
        b.insertAtBeg(20);
        b.insertAtBeg(30);
        b.printList();
    }
}
