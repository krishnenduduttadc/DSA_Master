package CodingShuttle.LL;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(4);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printLinkedList(head);

        Node newHead = removeDuplicateElements(head);

        printLinkedList(newHead);
    }

    static Node removeDuplicateElements(Node head) {
        Node orig = head;
        Node newHead = null;
        Node temp = head;

        while (orig != null) {
            while (orig.next != null && orig.data == orig.next.data) {
                orig = orig.next;
            }
            if (newHead == null) {
                newHead = temp = orig;
            } else {
                temp.next = orig;
                temp = orig;
            }
            orig = orig.next;
        }
        return newHead;
    }

    static void printLinkedList(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
