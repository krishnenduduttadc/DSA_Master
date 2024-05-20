package LinkedList2;

public class SumLists {
    public static class Node {
        int data;
        Node next;

        Node() {
            this.next = null;
        }
        Node(int data) {
            this.data = data;
            this.next = null;
        }
        void setNext(Node next) {
            this.next = next;
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
        Node head1 = new Node(7);
        head1.next = new Node(1);
        head1.next.next = new Node(6);


        Node head2 = new Node(5);
        head2.next = new Node(9);
        head2.next.next = new Node(2);

        Node result=add(head1,head2,0);
        printList(result);

    }

    static Node add(Node l1,Node l2,int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }
        Node result=new Node();
        int value=carry;
        if(l1!=null){
            value+=l1.data;
        }
        if(l2!=null){
            value+=l2.data;
        }
        result.data=value%10;

        if(l1!=null || l2!=null){
            Node more=add(l1==null?null: l1.next, l2==null?null:l2.next,value>=10?1:0);
            result.setNext(more);
        }
        return result;
    }
}
