package LinkedList2;

public class SubListSumEqualsK {

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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(5);

        // Print the linked list
        printList(head);
        int k=7;
        sublist(head,k);
    }

    static void sublist(Node head,int k){
        Node i=head;
        while(i!=null){
            Node j=i;
            while(j!=null){
                if(i.data+j.data==k){
                    System.out.print(i.data+" and "+j.data+ " equals "+ k);
                }
                j=j.next;
            }
            System.out.println("");
            i=i.next;
        }
     }
}
