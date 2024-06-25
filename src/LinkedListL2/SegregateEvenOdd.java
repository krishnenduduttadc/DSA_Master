package LinkedListL2;

public class SegregateEvenOdd {
    public static class Node {
        int val = 0;
        Node next = null;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node segregateEvenOdd(Node head) {
        if(head == null || head.next == null) return head;

        Node dummyEven = new Node(-1);
        Node dummyOdd = new Node(-1);
        Node evenTail = dummyEven, oddTail = dummyOdd, curr = head;

        while(curr != null){
            if(curr.val % 2 != 0){
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }

            curr = curr.next;
        }

        evenTail.next = dummyOdd.next;
        oddTail.next = null;
        return dummyEven.next;
    }

    static Node head;
    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }
    public static void main(String[] args) {

        SegregateEvenOdd llist=new SegregateEvenOdd();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        Node head1 = segregateEvenOdd(head);
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
}
