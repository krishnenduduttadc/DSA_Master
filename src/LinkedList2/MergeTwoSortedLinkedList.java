package LinkedList2;

public class MergeTwoSortedLinkedList {
    //public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 != null ? l1:l2;

        ListNode dummy = new ListNode(-1);
        ListNode prev =dummy;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }

            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;

        return dummy.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }



     static ListNode head1,head2;

    void push(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head1;
        head1 = new_node;
    }
    void push2(int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head2;
        head2 = new_node;
    }
    public static void main(String[] args) {
        MergeTwoSortedLinkedList llist1=new MergeTwoSortedLinkedList();
        llist1.push(1);
        llist1.push(2);
        llist1.push(3);

//        ListNode h1 = createList(n);
//        int m = scn.nextInt();

        MergeTwoSortedLinkedList llist2=new MergeTwoSortedLinkedList();
        llist2.push(1);
        llist2.push(2);
        llist2.push(3);
        //ListNode h2 = createList(m);


        ListNode head3 = mergeTwoLists(head1, head2);
        printList(head3);
    }
}
