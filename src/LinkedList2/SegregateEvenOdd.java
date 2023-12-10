package LinkedList2;

public class SegregateEvenOdd {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummyEven = new ListNode(-1);
        ListNode dummyOdd = new ListNode(-1);
        ListNode evenTail = dummyEven, oddTail = dummyOdd, curr = head;

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

    static ListNode head;
    void push(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }
    public static void main(String[] args) {

        SegregateEvenOdd llist=new SegregateEvenOdd();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        ListNode head1 = segregateEvenOdd(head);
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
}
