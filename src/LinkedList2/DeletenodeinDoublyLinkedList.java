package LinkedList2;



public class DeletenodeinDoublyLinkedList {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Function to delete the node at position x and return the head of the linked list
    Node deleteNode(Node head, int x) {
        if (head == null || x <= 0) return head; // If list is empty or position is invalid

        Node d = head;

        // Traverse to the node at position x
        for (int i = 1; i < x; i++) {
            d = d.next;
            if (d == null) return head; // If position x is out of bounds
        }

        // If the node to be deleted is the head node
        if (d.prev == null) {
            head = d.next;
            if (head != null) head.prev = null;
        }
        // If the node to be deleted is the tail node
        else if (d.next == null) {
            d.prev.next = null;
        }
        // If the node to be deleted is in the middle
        else {
            d.prev.next = d.next;
            d.next.prev = d.prev;
        }

        // Disconnect the deleted node from the list
        d.next = null;
        d.prev = null;

        return head;
    }

    // Utility function to print the list from head to tail
     void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeletenodeinDoublyLinkedList sol = new DeletenodeinDoublyLinkedList();

        // Creating a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original List:");
        sol.printList(head);

        // Delete node at position 3 (1-based index)
        head = sol.deleteNode(head, 3);
        System.out.println("List after deleting node at position 3:");
        sol.printList(head);

        // Delete node at position 1 (head)
        head = sol.deleteNode(head, 1);
        System.out.println("List after deleting node at position 1:");
        sol.printList(head);

        // Delete node at position 4 (tail)
        head = sol.deleteNode(head, 3); // Note: current length is 3 after deletions
        System.out.println("List after deleting node at position 3:");
        sol.printList(head);
    }
}
