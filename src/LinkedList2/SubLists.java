package LinkedList2;

public class SubLists {

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
        //int k=3;
         sublists(head);
    }

     static void sublists(Node head){
        Node i=head;
        while(i!=null){
            Node j=i;
            while(j!=null){
                System.out.print(j.data+"->");
                j=j.next;
            }
            System.out.println("null");
            i=i.next;
        }

     }
}
