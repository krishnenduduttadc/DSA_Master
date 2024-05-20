package LinkedList2;

public class KthFromLast {
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

        // Print the linked list
        printList(head);
        int k=3;
        System.out.println("Present at index: "+printKthToLast(head,k));
    }

    static int printKthToLast(Node head,int k){
        if(head==null){
            return 0;
        }
        int idx=printKthToLast(head.next,k)+1;
        if(idx==k){
            System.out.println(head.data);
        }
        return idx;
    }
}
