package LinkedList2;

public class DeleteAnyMiddleNode {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list with 5 hard-coded nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(5);


        printList(head);
        //delete third node
        System.out.println(delete(head.next.next));
        printList(head);
    }

    static boolean delete(Node givennode){
        if(givennode==null || givennode.next==null){
            return false;
        }
        Node next=givennode.next;
        givennode.data=next.data;
        givennode.next=next.next;
        return true;
    }
}
